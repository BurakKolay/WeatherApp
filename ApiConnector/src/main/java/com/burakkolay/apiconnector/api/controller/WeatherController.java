package com.burakkolay.apiconnector.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weather")
@RequiredArgsConstructor
public class WeatherController {
//    private final WeatherManager weatherManager;
//
//    @GetMapping
//    public GetWeatherDTO getWeather(@RequestParam String city){
//        return weatherManager.getWeather(city);
//    }
}
