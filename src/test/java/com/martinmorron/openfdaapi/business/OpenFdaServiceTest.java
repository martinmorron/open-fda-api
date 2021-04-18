package com.martinmorron.openfdaapi.business;

import com.martinmorron.openfdaapi.TestConfig;
import com.martinmorron.openfdaapi.api.DrugApplicationDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


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

    @BeforeEach
    void init() {
        openFdaService = new OpenFdaService("aFakeUrl", restTemplate,
                drugApplicationRepository, drugApplicationMapper);

        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    void getByManufacturerName() {


    }

    @Test
    void getByBrandName() {
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
        final List<DrugApplication> drugApplications = Collections.singletonList(DrugApplicationFixtures.buildDrugApplication());
        when(drugApplicationRepository.findAll()).thenReturn(drugApplications);
        final List<DrugApplicationDTO> dtos = Collections.singletonList(DrugApplicationFixtures.buildDrugApplicationDTO());
        when(drugApplicationMapper.toDTOs(drugApplications)).thenReturn(dtos);
        final List<DrugApplicationDTO> result = openFdaService.getApplications();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getApplicationNumber()).isEqualTo(DrugApplicationFixtures.AN_APPLICATION_NUMBER);
    }
}