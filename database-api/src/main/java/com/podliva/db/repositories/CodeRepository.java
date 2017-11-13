package com.podliva.db.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.podliva.db.models.CodeInformation;

public interface CodeRepository extends MongoRepository<CodeInformation, String> {
    CodeInformation findByCode(String code);
}
