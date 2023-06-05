package com.burakkolay.weatherservice.business.concretes;

import com.burakkolay.weatherservice.business.abstracts.UserService;
import com.burakkolay.weatherservice.business.rules.UserBusinessRules;
import com.burakkolay.weatherservice.entities.User;
import com.burakkolay.weatherservice.entities.Weather;
import com.burakkolay.weatherservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {
    private final UserRepository repository;
    private final WeatherManager weatherManager;
    private final UserBusinessRules rules;

    @Override
    public void saveCity(String city) {
        Optional<User> user = rules.getUserPrincipals();
        ArrayList<String> cities = user.get().getCities();
        if (cities == null)
            cities = new ArrayList<>();
        cities.add(city);
        user.get().setCities(cities);
        user.ifPresent(repository::save);
    }

    @Override
    public HashMap<String, Weather> getWeatherOfSavedCities() {
        Optional<User> user = rules.getUserPrincipals();
        ArrayList<String> cities = user.get().getCities();
        HashMap<String, Weather> weather = new HashMap<>();
        for (String city : cities)
            weather.put(city, weatherManager.getWeather(city));
        return weather;

    }
}
