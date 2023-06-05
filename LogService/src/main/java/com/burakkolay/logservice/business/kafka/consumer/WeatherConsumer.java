package com.burakkolay.logservice.business.kafka.consumer;
import com.burakkolay.logservice.business.abstracts.LogService;
import com.burakkolay.logservice.business.mapper.LogMapper;
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
    private final LogMapper mapper;
    @PostConstruct
    public void createDb(){
        service.add(new Log());
    }
    @KafkaListener(
            topics = "logging",
            groupId = "logging-for-db"
    )
    public void consume(LogDTO log) {
        Log logs = mapper.toLog(log);
        service.add(logs);
    }
}
