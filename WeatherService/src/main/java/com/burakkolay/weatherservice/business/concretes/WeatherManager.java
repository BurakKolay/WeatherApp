package com.burakkolay.weatherservice.business.concretes;


import com.burakkolay.commonpackage.kafka.producer.KafkaProducer;
import com.burakkolay.weatherservice.api.client.WeatherApi;
import com.burakkolay.weatherservice.business.rules.UserBusinessRules;
import com.burakkolay.commonpackage.business.dto.response.LogDTO;
import com.burakkolay.weatherservice.configuration.exceptions.BusinessException;
import com.burakkolay.weatherservice.configuration.exceptions.Messages.Messages;
import com.burakkolay.weatherservice.entities.Weather;
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
    private final UserBusinessRules rules;


    @PreAuthorize("hasRole('USER')")
    public Weather getWeather(String city) {
        producer.sendMessage(new LogDTO(rules.getUserPrincipals().getUsername(),"Get Weather"),"logging");
        try{
            return weatherApi.getWeather(city, appId, units);
        }catch (RuntimeException e){
            throw new BusinessException(Messages.Weather.CityNotFound);
        }
    }
}
