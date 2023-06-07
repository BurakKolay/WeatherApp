package com.burakkolay.weatherservice.api.controller;

import com.burakkolay.weatherservice.business.abstracts.UserService;
import com.burakkolay.weatherservice.entities.User;
import com.burakkolay.weatherservice.entities.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/{city}")
    public ResponseEntity<User> addCity(@PathVariable String city){
        return ResponseEntity.ok(service.saveCity(city));
    }

    @GetMapping
    public ResponseEntity<HashMap<String, Weather>> getAll(){
        return ResponseEntity.ok(service.getWeatherOfSavedCities());
    }
}
