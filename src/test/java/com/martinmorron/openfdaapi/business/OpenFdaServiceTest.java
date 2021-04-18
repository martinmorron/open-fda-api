package com.martinmorron.openfdaapi.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.martinmorron.openfdaapi.TestConfig;
import com.martinmorron.openfdaapi.api.DrugApplicationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
class OpenFdaServiceTest {

    @Mock
    private DrugApplicationMapper drugApplicationMapper;

    @Mock
    private DrugApplicationRepository drugApplicationRepository;

    @Autowired
    private RestTemplate restTemplate;

    private MockRestServiceServer mockServer;

    private OpenFdaService openFdaService;

    private static ObjectMapper MAPPER = new ObjectMapper();

    @BeforeEach
    void init() {
        openFdaService = new OpenFdaService("http://afakeurl.com/fake.json", restTemplate,
                drugApplicationRepository, drugApplicationMapper);

        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    void getByManufacturerName_whenGetResult_shouldReturnPaginated() throws Exception {
        final OpenFdaResponse response = buildResponse();

        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI("http://afakeurl.com/fake.json?search=openfda.brand_name:'XXBrand'&limit=20&skip=0")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(MAPPER.writeValueAsString(response))
                );

        final PageImpl<Result> result = openFdaService.getByBrandName("XXBrand", PageRequest.of(0, 20));

        assertThat(result.getTotalElements()).isPositive();
        assertThat(result.get().allMatch(res -> res.getApplicationNumber().equals("AN_APPLICATION_NUMBER"))).isTrue();

        mockServer.verify();
    }

    @Test
    void getByManufacturerName_whenCallFails_shouldReturnEmptyResult() throws Exception {
        final OpenFdaResponse response = buildFailureResponse();

        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI("http://afakeurl.com/fake.json?search=openfda.brand_name:'XXBrand'&limit=20&skip=0")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(MAPPER.writeValueAsString(response))
                );

        final PageImpl<Result> result = openFdaService.getByBrandName("XXBrand", PageRequest.of(0, 20));

        assertThat(result.getTotalElements()).isZero();

        mockServer.verify();
    }

    @Test
    void getByBrandName_whenGetResult_shouldReturnPaginated() throws Exception {
        final OpenFdaResponse response = buildResponse();

        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI("http://afakeurl.com/fake.json?search=openfda.manufacturer_name:'XXManufacturer'&limit=20&skip=0")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(MAPPER.writeValueAsString(response))
                );

        final PageImpl<Result> result = openFdaService.getByManufacturerName("XXManufacturer", PageRequest.of(0, 20));

        assertThat(result.getTotalElements()).isPositive();
        assertThat(result.get().allMatch(res -> res.getApplicationNumber().equals("AN_APPLICATION_NUMBER"))).isTrue();

        mockServer.verify();
    }

    @Test
    void getByBrandName_whenCallFails_shouldReturnEmptyResult() throws Exception {
        final OpenFdaResponse response = buildFailureResponse();

        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI("http://afakeurl.com/fake.json?search=openfda.brand_name:'XXBrand'&limit=20&skip=0")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(MAPPER.writeValueAsString(response))
                );

        final PageImpl<Result> result = openFdaService.getByBrandName("XXBrand", PageRequest.of(0, 20));

        assertThat(result.getTotalElements()).isZero();

        mockServer.verify();
    }

    @Test
    void storeApplication_whenIsCalled_shouldStoreData() {
        final DrugApplicationDTO dto = DrugApplicationFixtures.buildDrugApplicationDTO();
        final DrugApplication application = DrugApplicationFixtures.buildDrugApplication();
        when(drugApplicationMapper.toEntity(dto)).thenReturn(application);

        openFdaService.storeApplication(dto);

        verify(drugApplicationRepository, times(1)).save(application);

    }

    @Test
    void getApplications_whenHasData_shouldRetrieveInformation() {
        final List<DrugApplication> drugApplications = singletonList(DrugApplicationFixtures.buildDrugApplication());
        when(drugApplicationRepository.findAll()).thenReturn(drugApplications);
        final List<DrugApplicationDTO> dtos = singletonList(DrugApplicationFixtures.buildDrugApplicationDTO());
        when(drugApplicationMapper.toDTOs(drugApplications)).thenReturn(dtos);
        final List<DrugApplicationDTO> result = openFdaService.getApplications();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getApplicationNumber()).isEqualTo(DrugApplicationFixtures.AN_APPLICATION_NUMBER);
    }

    private OpenFdaResponse buildResponse() {
        final Result aResult = Result.builder().applicationNumber("AN_APPLICATION_NUMBER").build();
        final Results results = new Results();
        results.setTotal(20);
        final Meta meta = new Meta();
        meta.setResults(results);
        return new OpenFdaResponse(meta, singletonList(aResult));
    }

    private OpenFdaResponse buildFailureResponse() {
        return new OpenFdaResponse(null, null);
    }
}