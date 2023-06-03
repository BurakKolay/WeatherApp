package com.burakkolay.apiconnector.business.kafka.consumer;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherConsumer {
//    private final WeatherManager manager;
//    @KafkaListener(
//            topics = "get-weather",
//            groupId = "getting-weather"
//    )
//    public void consume(String city){
//        GetWeatherDTO weather = manager.getWeather(city);
//        log.info(weather.toString());
//        manager.sendWeather(weather);
//    }
}
