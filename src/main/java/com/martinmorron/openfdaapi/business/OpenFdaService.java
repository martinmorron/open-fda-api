package com.martinmorron.openfdaapi.business;

import com.martinmorron.openfdaapi.api.DrugApplicationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
public class OpenFdaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenFdaService.class);
    private static final String MANUFACTURER_QUERY_PARAM_FORMAT = "openfda.manufacturer_name:'%s'";
    private static final String BRAND_QUERY_PARAM_FORMAT = "openfda.brand_name:'%s'";

    private final String basicUrl;
    private final RestTemplate restTemplate;
    private final DrugApplicationRepository drugApplicationRepository;
    private final DrugApplicationMapper drugApplicationMapper;

    public OpenFdaService(@Value("${openfda.api.url}") String basicUrl,
                          RestTemplate restTemplate,
                          DrugApplicationRepository drugApplicationRepository,
                          DrugApplicationMapper drugApplicationMapper) {

        this.basicUrl = basicUrl;
        this.drugApplicationRepository = drugApplicationRepository;
        this.drugApplicationMapper = drugApplicationMapper;
        this.restTemplate = restTemplate;
    }

    public PageImpl<Result> getByManufacturerName(final String manufacturerName, final Pageable pageable) {
        UriComponentsBuilder uriBuilder = buildSearchUri(manufacturerName, pageable, MANUFACTURER_QUERY_PARAM_FORMAT);

        return fetchResults(pageable, uriBuilder);
    }

    public PageImpl<Result> getByBrandName(final String brandName, final Pageable pageable) {
        UriComponentsBuilder uriBuilder = buildSearchUri(brandName, pageable, BRAND_QUERY_PARAM_FORMAT);

        return fetchResults(pageable, uriBuilder);
    }

    public void storeApplication(final DrugApplicationDTO drugApplicationDTO) {

        final DrugApplication drugApplications = drugApplicationMapper.toEntity(drugApplicationDTO);

        drugApplicationRepository.save(drugApplications);
    }

    public List<DrugApplicationDTO> getApplications() {
        final List<DrugApplication> results = drugApplicationRepository.findAll();

        return drugApplicationMapper.toDTOs(results);
    }

    private PageImpl<Result> fetchResults(Pageable pageable, UriComponentsBuilder uriBuilder) {
        try {
            return Optional.ofNullable(getData(uriBuilder.toUriString()))
                    .map(response -> new PageImpl<>(response.getResults(), pageable, response.getMeta().getResults().getTotal()))
                    .orElse(new PageImpl<>(emptyList(), pageable, 0));
        } catch (Exception e) {
            LOGGER.error("Unable to get application information ", e);
            return new PageImpl<>(emptyList(), pageable, 0);
        }
    }

    private UriComponentsBuilder buildSearchUri(final String brandName, final Pageable pageable, final String field) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(basicUrl);
        uriBuilder.queryParam("search", String.format(field, brandName));
        setPagination(pageable, uriBuilder);
        return uriBuilder;
    }

    private void setPagination(Pageable pageable, UriComponentsBuilder uriBuilder) {
        uriBuilder.queryParam("limit", pageable.getPageSize());
        uriBuilder.queryParam("skip", pageable.getOffset());
    }

    private OpenFdaResponse getData(String url) {
        final ResponseEntity<OpenFdaResponse> forEntity = restTemplate.getForEntity(url, OpenFdaResponse.class);
        return forEntity.getBody();
    }
}
