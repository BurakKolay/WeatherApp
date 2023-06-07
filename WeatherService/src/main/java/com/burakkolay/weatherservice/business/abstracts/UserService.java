package com.burakkolay.weatherservice.business.abstracts;

import com.burakkolay.weatherservice.entities.User;
import com.burakkolay.weatherservice.entities.Weather;
import java.util.HashMap;

public interface UserService {
    User saveCity(String city);
    HashMap<String , Weather> getWeatherOfSavedCities();
}
