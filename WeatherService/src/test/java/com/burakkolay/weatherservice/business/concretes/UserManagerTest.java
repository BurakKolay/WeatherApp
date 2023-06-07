package com.burakkolay.weatherservice.business.concretes;


import com.burakkolay.commonpackage.kafka.producer.KafkaProducer;
import com.burakkolay.weatherservice.business.rules.UserBusinessRules;
import com.burakkolay.weatherservice.configuration.exceptions.BusinessException;
import com.burakkolay.weatherservice.entities.Role;
import com.burakkolay.weatherservice.entities.User;
import com.burakkolay.weatherservice.entities.Weather;
import com.burakkolay.weatherservice.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;

@ExtendWith(MockitoExtension.class)
class UserManagerTest {

    @Mock
    private UserRepository repository;
    @Mock
    private UserBusinessRules rules;
    @Mock
    private KafkaProducer producer;
    @InjectMocks
    private UserManager userManager;

    @Mock
    private WeatherManager weatherManager;

    @Test
    void shouldGetWeatherOfCities(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("sakarya");
        User user = new User(1L, "burak", "kolay", "burak", "12345", arrayList, Role.ROLE_USER);
        Weather weather = new Weather();
        Mockito.when(rules.getUserPrincipals()).thenReturn(user);
        Mockito.when(weatherManager.getWeather(Mockito.any())).thenReturn(weather);
        HashMap<String, Weather> weatherOfSavedCities = userManager.getWeatherOfSavedCities();
        Assertions.assertEquals(weatherOfSavedCities.get("sakarya"),weather);
    }
    @Test
    void shouldNotGetWeatherOfCities(){
        User user = new User(1L, "burak", "kolay", "burak", "12345", null, Role.ROLE_USER);
        Mockito.when(rules.getUserPrincipals()).thenReturn(user);
        Mockito.doThrow(BusinessException.class).when(rules).checkIfUserCityNotExists(user);
        Assertions.assertThrows(BusinessException.class,() -> userManager.getWeatherOfSavedCities());
    }

    @Test
    void shouldSaveCity() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("sakarya");
        User user = new User(1L, "burak", "kolay", "burak", "12345", null, Role.ROLE_USER);
        Mockito.when(rules.getUserPrincipals()).thenReturn(user);
        Weather weather = new Weather();
        Mockito.when(weatherManager.getWeather(Mockito.any())).thenReturn(weather);
        Mockito.when(repository.save(Mockito.any())).thenReturn(user);
        User user1 = userManager.saveCity("sakarya");
        user.setCities(arrayList);
        Assertions.assertEquals(user,user1);
    }

    @Test
    void shouldNotSaveCityForCityAlreadyExists(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("sakarya");
        User user = new User(1L, "burak", "kolay", "burak", "12345", arrayList, Role.ROLE_USER);
        Mockito.when(rules.getUserPrincipals()).thenReturn(user);
        Mockito.doThrow(BusinessException.class).when(rules).checkIfCityExists("sakarya",user);
        Assertions.assertThrows(BusinessException.class,() -> userManager.saveCity("sakarya"));
    }

    @Test
    void shouldNotSaveCityForCityNotFound(){
        User user = new User(1L, "burak", "kolay", "burak", "12345", null, Role.ROLE_USER);
        Mockito.when(rules.getUserPrincipals()).thenReturn(user);
        Mockito.doThrow(BusinessException.class).when(weatherManager).getWeather("burak");
        Assertions.assertThrows(BusinessException.class,() -> userManager.saveCity("burak"));
    }
}