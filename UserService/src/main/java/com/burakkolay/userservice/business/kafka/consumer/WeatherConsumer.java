package com.burakkolay.userservice.business.kafka.consumer;

import com.burakkolay.commonpackage.business.dto.response.GetWeatherDTO;
import com.burakkolay.userservice.business.concretes.WeatherManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherConsumer {
    private final WeatherManager manager;
    @KafkaListener(
            topics = "send-weather",
            groupId = "sending-weather"
    )
    public void consume(GetWeatherDTO weather){
        manager.weatherDTO(weather);
    }
}
