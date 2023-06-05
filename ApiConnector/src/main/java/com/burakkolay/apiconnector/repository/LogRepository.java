package com.burakkolay.apiconnector.repository;

import com.burakkolay.apiconnector.entities.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, String> {
}
