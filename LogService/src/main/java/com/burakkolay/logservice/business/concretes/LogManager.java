package com.burakkolay.logservice.business.concretes;

import com.burakkolay.logservice.business.abstracts.LogService;
import com.burakkolay.logservice.entities.Log;
import com.burakkolay.logservice.repository.LogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LogManager implements LogService {
    private final LogRepository repository;
    @Override
    public Log add(Log log) {
        return repository.save(log);
    }

    @Override
    public List<Log> getAll() {
        return repository.findAll();
    }

    @Override
    public Log getById(String id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
