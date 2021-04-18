package com.martinmorron.openfdaapi.business;

import com.martinmorron.openfdaapi.api.DrugApplicationDTO;

import java.util.Collections;
import java.util.List;

public class DrugApplicationFixtures {

    public static final String AN_APPLICATION_NUMBER = "AN_APPLICATION_NUMBER";
    public static final List<String> SUBSTANCE_NAME = Collections.singletonList("A_SUBSTANCE");
    public static final List<String> PRODUCT_NUMBERS = Collections.singletonList("123");
    public static final List<String> MANUFACTURER_NAME = Collections.singletonList("MANUFACTURER");

    public static DrugApplication buildDrugApplication() {
        return DrugApplication.builder()
                .productNumbers(PRODUCT_NUMBERS)
                .applicationNumber(AN_APPLICATION_NUMBER)
                .manufacturerName(MANUFACTURER_NAME)
                .substanceName(SUBSTANCE_NAME)
                .build();
    }

    public static DrugApplicationDTO buildDrugApplicationDTO() {
        final DrugApplicationDTO dto = DrugApplicationDTO.builder()
                .applicationNumber(AN_APPLICATION_NUMBER)
                .substanceName(SUBSTANCE_NAME)
                .productNumbers(PRODUCT_NUMBERS)
                .manufacturerName(MANUFACTURER_NAME)
                .build();
        return dto;
    }
}
