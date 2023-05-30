package com.burakkolay.apiconnector.business.kafka.consumer;


import com.burakkolay.apiconnector.business.concretes.WeatherManager;
import com.burakkolay.commonpackage.business.dto.response.GetWeatherDTO;
import com.burakkolay.commonpackage.kafka.producer.KafkaProducer;
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
            topics = "get-weather",
            groupId = "getting-weather"
    )
    public void consume(String city){
        GetWeatherDTO weather = manager.getWeather(city);
        log.info(weather.toString());
        manager.sendWeather(weather);
    }
}
