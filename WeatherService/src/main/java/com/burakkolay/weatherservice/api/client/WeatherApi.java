package com.burakkolay.weatherservice.api.client;


import com.burakkolay.weatherservice.entities.Weather;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weather", url = "api.openweathermap.org/data/2.5/forecast")
public interface WeatherApi {
    @GetMapping
    Weather getWeather(@RequestParam String q, @RequestParam String appid, @RequestParam String units);

}
