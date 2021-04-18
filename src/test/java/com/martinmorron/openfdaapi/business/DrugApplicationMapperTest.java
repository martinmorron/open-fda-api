package com.martinmorron.openfdaapi.business;

import com.martinmorron.openfdaapi.api.DrugApplicationDTO;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static com.martinmorron.openfdaapi.business.DrugApplicationFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;

class DrugApplicationMapperTest {

    private final DrugApplicationMapper mapper = new DrugApplicationMapper();

    @Test
    void toDTOs_whenIsCalled_shouldMapValues() {

        final DrugApplication drugApplication = buildDrugApplication();

        final List<DrugApplicationDTO> dtos = mapper.toDTOs(Collections.singletonList(drugApplication));

        assertThat(dtos).hasSize(1);
        assertThat(dtos.get(0).getApplicationNumber()).isEqualTo(AN_APPLICATION_NUMBER);
        assertThat(dtos.get(0).getSubstanceName()).isEqualTo(SUBSTANCE_NAME);
        assertThat(dtos.get(0).getProductNumbers()).isEqualTo(PRODUCT_NUMBERS);
        assertThat(dtos.get(0).getManufacturerName()).isEqualTo(MANUFACTURER_NAME);
    }

    @Test
    void toEntity_whenIsCalled_shouldMapValue() {
        final DrugApplicationDTO dto = buildDrugApplicationDTO();

        final DrugApplication drugApplication = mapper.toEntity(dto);

        assertThat(drugApplication.getApplicationNumber()).isEqualTo(AN_APPLICATION_NUMBER);
        assertThat(drugApplication.getSubstanceName()).isEqualTo(SUBSTANCE_NAME);
        assertThat(drugApplication.getProductNumbers()).isEqualTo(PRODUCT_NUMBERS);
        assertThat(drugApplication.getManufacturerName()).isEqualTo(MANUFACTURER_NAME);
    }

}