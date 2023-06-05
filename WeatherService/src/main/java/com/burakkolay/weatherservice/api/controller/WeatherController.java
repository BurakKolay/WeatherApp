package com.burakkolay.weatherservice.api.controller;

import com.burakkolay.weatherservice.business.concretes.WeatherManager;
import com.burakkolay.weatherservice.entities.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherManager weatherManager;

    @GetMapping
    public Weather getWeather(@RequestParam String city){
        return weatherManager.getWeather(city);
    }
}
