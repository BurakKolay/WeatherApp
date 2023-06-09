package com.burakkolay.weatherservice.business.concretes;

import com.burakkolay.commonpackage.business.dto.response.LogDTO;
import com.burakkolay.commonpackage.kafka.producer.KafkaProducer;
import com.burakkolay.weatherservice.business.abstracts.UserService;
import com.burakkolay.weatherservice.business.rules.UserBusinessRules;
import com.burakkolay.weatherservice.entities.User;
import com.burakkolay.weatherservice.entities.Weather;
import com.burakkolay.weatherservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {
    private final UserRepository repository;
    private final WeatherManager weatherManager;
    private final KafkaProducer producer;
    private final UserBusinessRules rules;

    @Override
    public User saveCity(String city) {
        User user = rules.getUserPrincipals();
        producer.sendMessage(new LogDTO(user.getUsername(), "Save city"),"logging");
        rules.checkIfCityExists(city,user);
        weatherManager.getWeather(city);
        ArrayList<String> cities = user.getCities();
        if (cities == null)
            cities = new ArrayList<>();
        cities.add(city);
        user.setCities(cities);

        return repository.save(user);
    }

    @Override
    public HashMap<String, Weather> getWeatherOfSavedCities() {
        User user = rules.getUserPrincipals();
        producer.sendMessage(new LogDTO(user.getUsername(), "Get Weather Of Cities"),"logging");
        rules.checkIfUserCityNotExists(user);
        ArrayList<String> cities = user.getCities();
        HashMap<String, Weather> weather = new HashMap<>();
        for (String city : cities)
            weather.put(city, weatherManager.getWeather(city));
        return weather;
    }
}
