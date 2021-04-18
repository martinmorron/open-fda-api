package com.martinmorron.openfdaapi.business;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugApplicationRepository extends MongoRepository<DrugApplication, String> {
}
