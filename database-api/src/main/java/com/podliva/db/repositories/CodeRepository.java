package com.podliva.db.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.podliva.db.models.CodeInformation;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "coupon", path = "coupon")
public interface CodeRepository extends MongoRepository<CodeInformation, String> {
    CodeInformation findByCode(String code);
}
