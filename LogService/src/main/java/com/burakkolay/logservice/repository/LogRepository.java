package com.burakkolay.logservice.repository;

import com.burakkolay.logservice.entities.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, String> {
}
