package com.burakkolay.apiconnector.business.concretes;

import com.burakkolay.apiconnector.business.abstracts.LogService;
import com.burakkolay.apiconnector.entities.Log;
import com.burakkolay.apiconnector.repository.LogRepository;
import jakarta.annotation.PostConstruct;
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
    @PostConstruct
    public void createDb(){
        add(new Log());
    }
}
