package com.burakkolay.userservice.business.concretes;


import com.burakkolay.commonpackage.business.dto.response.GetWeatherDTO;
import com.burakkolay.commonpackage.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherManager {
    private final KafkaProducer producer;

    public void getWeather(String city){
        producer.sendMessage(city,"get-weather");
    }
    public GetWeatherDTO weatherDTO(GetWeatherDTO weather){
        return weather;
    }
}
