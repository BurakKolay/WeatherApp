package com.burakkolay.weatherservice.business.concretes;


import com.burakkolay.commonpackage.business.dto.response.GetWeatherDTO;
import com.burakkolay.commonpackage.kafka.producer.KafkaProducer;
import com.burakkolay.weatherservice.api.client.WeatherApi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherManager {
    @Value("${openweathermap.api.key}")
    private String appId;
    @Value("${openweathermap.api.units}")
    private String units;
    private final WeatherApi weatherApi;
    private final KafkaProducer producer;


    @PreAuthorize("hasRole('USER')")
    public GetWeatherDTO getWeather(String city) {
        GetWeatherDTO weather = weatherApi.getWeather(city, appId,units);
        return weather;
    }
}
