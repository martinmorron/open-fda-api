package com.martinmorron.openfdaapi.business;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class PersistenceITTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private DrugApplicationRepository drugApplicationRepository;

    @AfterEach
    void after() {
        mongoTemplate.dropCollection(DrugApplication.class);
    }

    @Test
    void save_shouldPersist() {

        final DrugApplication entity = DrugApplication
                .builder()
                .applicationNumber("APP-NUMBER-1")
                .build();

        drugApplicationRepository.save(entity);

        final List<DrugApplication> results = mongoTemplate.findAll(DrugApplication.class);

        Assertions.assertThat(results).hasSize(1);
        Assertions.assertThat(results)
                .element(0)
                .extracting(DrugApplication::getApplicationNumber)
                .isEqualTo("APP-NUMBER-1");

    }

    @Test
    void findAll_shouldRetrieveDataFromDB() {
        final DrugApplication entity = DrugApplication
                .builder()
                .applicationNumber("APP-NUMBER-2")
                .build();

        mongoTemplate.save(entity);

        final List<DrugApplication> results = drugApplicationRepository.findAll();

        Assertions.assertThat(results).hasSize(1);
        Assertions.assertThat(results)
                .element(0)
                .extracting(DrugApplication::getApplicationNumber)
                .isEqualTo("APP-NUMBER-2");

    }
}
