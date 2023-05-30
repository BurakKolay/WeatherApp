package com.burakkolay.userservice.api.controller;

import com.burakkolay.commonpackage.business.dto.response.GetWeatherDTO;
import com.burakkolay.userservice.business.concretes.WeatherManager;
import com.burakkolay.userservice.business.kafka.consumer.WeatherConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherManager manager;
    private final WeatherConsumer consumer;
    @GetMapping
    public GetWeatherDTO getWeather(@RequestParam String city){
        manager.getWeather(city);
    }
}
