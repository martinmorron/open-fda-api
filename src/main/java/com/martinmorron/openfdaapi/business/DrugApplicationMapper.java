package com.martinmorron.openfdaapi.business;

import com.martinmorron.openfdaapi.api.DrugApplicationDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrugApplicationMapper {

    public List<DrugApplicationDTO> toDTOs(final List<DrugApplication> drugApplications) {

        return drugApplications.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private DrugApplicationDTO toDTO(DrugApplication drugApplication) {
        return DrugApplicationDTO.builder()
                .applicationNumber(drugApplication.getApplicationNumber())
                .manufacturerName(drugApplication.getManufacturerName())
                .substanceName(drugApplication.getSubstanceName())
                .productNumbers(drugApplication.getProductNumbers())
                .build();
    }

    DrugApplication toEntity(final DrugApplicationDTO result) {

        return DrugApplication.builder()
                .applicationNumber(result.getApplicationNumber())
                .manufacturerName(result.getManufacturerName())
                .substanceName(result.getSubstanceName())
                .productNumbers(result.getProductNumbers())
                .build();
    }

}
