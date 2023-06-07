package com.burakkolay.weatherservice.api.controller;

import com.burakkolay.weatherservice.business.abstracts.UserService;
import com.burakkolay.weatherservice.entities.Role;
import com.burakkolay.weatherservice.entities.User;
import com.burakkolay.weatherservice.entities.Weather;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService service;
    @InjectMocks
    private UserController userController;
    @Test
    void addCity() {
        String city = "Sakarya";
        User user = new User(1L, "burak", "kolay", "burak", "12345", null, Role.ROLE_USER);
        when(service.saveCity(Mockito.any())).thenReturn(user);
        ResponseEntity<User> userResponseEntity = userController.addCity(city);
        assertEquals(HttpStatus.OK,userResponseEntity.getStatusCode());
        assertEquals(user,userResponseEntity.getBody());

        verify(service,times(1)).saveCity(city);
    }

    @Test
    void getAll() {
        HashMap<String , Weather> stringWeatherHashMap= new HashMap<>();
        when(service.getWeatherOfSavedCities()).thenReturn(stringWeatherHashMap);
        ResponseEntity<HashMap<String, Weather>> all = userController.getAll();
        assertEquals(HttpStatus.OK,all.getStatusCode());
        assertEquals(stringWeatherHashMap,all.getBody());
        verify(service,times(1)).getWeatherOfSavedCities();
    }
}