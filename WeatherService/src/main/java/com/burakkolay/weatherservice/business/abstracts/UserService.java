package com.burakkolay.weatherservice.business.abstracts;

import com.burakkolay.weatherservice.entities.Weather;
import java.util.HashMap;

public interface UserService {
    void saveCity(String city);
    HashMap<String , Weather> getWeatherOfSavedCities();
}
