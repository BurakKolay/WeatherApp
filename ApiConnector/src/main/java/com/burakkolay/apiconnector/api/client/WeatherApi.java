package com.burakkolay.apiconnector.api.client;

import com.burakkolay.apiconnector.business.dto.response.GetWeatherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weather", url = "api.openweathermap.org/data/2.5/forecast")
public interface WeatherApi {
    @GetMapping
    GetWeatherDTO getWeather(@RequestParam String q, @RequestParam String appid, @RequestParam String units);

}
