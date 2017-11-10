package com.podliva.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.podliva.models.CodeInformation;

public interface CodeRepository extends MongoRepository<CodeInformation, String> {
    CodeInformation findByCode(String code);
}
