package com.martinmorron.openfdaapi.api;

import com.martinmorron.openfdaapi.business.OpenFdaService;
import com.martinmorron.openfdaapi.business.Result;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class OpenFdaAPI {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenFdaAPI.class);

    private final OpenFdaService openFdaService;

    @GetMapping(params = {"name"}, value = "/brand")
    @PageableAsQueryParam
    public Page<Result> brand(@RequestParam String name, Pageable pageable) {
        LOGGER.info("Getting applications by brand: {}", name);
        return openFdaService.getByBrandName(name, pageable);

    }

    @GetMapping(params = {"name"}, value = "/manufacturer")
    @PageableAsQueryParam
    public Page<Result> manufacturer(@RequestParam String name, Pageable pageable) {
        LOGGER.info("Getting applications by manufacturer: {}", name);
        return openFdaService.getByManufacturerName(name, pageable);
    }

    @PostMapping(value = "/application")
    public void storeApplications(@RequestBody DrugApplicationDTO drugApplicationDTO) {
        LOGGER.info("To save: {}", drugApplicationDTO);
        openFdaService.storeApplication(drugApplicationDTO);
    }

    @GetMapping(value = "/application")
    public List<DrugApplicationDTO> getApplications() {
        return openFdaService.getApplications();
    }

}
