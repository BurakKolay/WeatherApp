package com.burakkolay.logservice.business.kafka.consumer;
import com.burakkolay.logservice.business.abstracts.LogService;
import com.burakkolay.logservice.entities.Log;
import com.burakkolay.commonpackage.business.dto.response.LogDTO;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WeatherConsumer {
    private final LogService service;

    @PostConstruct
    public void createDb(){
        service.add(new Log());
    }
    @KafkaListener(
            topics = "logging",
            groupId = "logging-for-db"
    )
    public void consume(LogDTO log) {
        System.out.println(log.getUsername());
        Log logs = new Log();
        logs.setCreateDate(log.getCreateDate());
        logs.setUsername(log.getUsername());
        logs.setOperations(log.getOperations());
        logs.setId(UUID.randomUUID().toString());
        service.add(logs);
    }
}
