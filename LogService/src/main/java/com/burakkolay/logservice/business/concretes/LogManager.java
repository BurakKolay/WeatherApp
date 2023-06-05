package com.burakkolay.logservice.business.concretes;

import com.burakkolay.logservice.business.abstracts.LogService;
import com.burakkolay.logservice.entities.Log;
import com.burakkolay.logservice.repository.LogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LogManager implements LogService {
    private final LogRepository repository;
    @Override
    public void add(Log log) {
        repository.save(log);
    }
}
