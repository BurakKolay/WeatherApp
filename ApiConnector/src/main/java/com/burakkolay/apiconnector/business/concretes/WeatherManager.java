package com.burakkolay.apiconnector.business.concretes;

import com.burakkolay.apiconnector.api.client.WeatherApi;
import com.burakkolay.apiconnector.business.dto.response.GetWeatherDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherManager {
    @Value("${openweathermap.api.key}")
    private String appId;
    @Value("${openweathermap.api.units}")
    private String units;
    private final WeatherApi weatherApi;

    public GetWeatherDTO getWeather(String city) {
        GetWeatherDTO weather = weatherApi.getWeather(city, appId,units);
        return weather;
    }
}
