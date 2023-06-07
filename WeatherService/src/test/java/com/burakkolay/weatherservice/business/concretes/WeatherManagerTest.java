package com.burakkolay.weatherservice.business.concretes;

import com.burakkolay.commonpackage.kafka.producer.KafkaProducer;
import com.burakkolay.weatherservice.api.client.WeatherApi;
import com.burakkolay.weatherservice.business.rules.UserBusinessRules;
import com.burakkolay.weatherservice.configuration.exceptions.BusinessException;
import com.burakkolay.weatherservice.configuration.exceptions.Messages.Messages;
import com.burakkolay.weatherservice.entities.Role;
import com.burakkolay.weatherservice.entities.User;
import com.burakkolay.weatherservice.entities.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class WeatherManagerTest {

    @InjectMocks
    private WeatherManager weatherManager;
    @Mock
    private WeatherApi weatherApi;
    @Mock
    private UserBusinessRules rules;
    @Mock
    private KafkaProducer producer;

    @Test
    void shouldGetWeather() {
        User user = new User(1L, "burak", "kolay", "burak", "12345", null, Role.ROLE_USER);
        Mockito.when(rules.getUserPrincipals()).thenReturn(user);
        Weather weather = new Weather();
        Mockito.when(weatherApi.getWeather("sakarya",null,null)).thenReturn(weather);
        Weather expWeather = weatherManager.getWeather("sakarya");
        Assertions.assertEquals(weather,expWeather);
    }

    @Test
    void shouldNotGetWeatherForCityNotFound() {
        User user = new User(1L, "burak", "kolay", "burak", "12345", null, Role.ROLE_USER);
        Mockito.when(rules.getUserPrincipals()).thenReturn(user);
        Weather weather = new Weather();
        Mockito.when(weatherApi.getWeather("ahmet","c8234ae4c35766b7da12adede42b8901","metric")).thenReturn(weather);
        BusinessException exception = assertThrows(BusinessException.class, () -> weatherManager.getWeather("ahmet"));
        Assertions.assertEquals(exception.getMessage(), Messages.Weather.CityNotFound);
    }
}