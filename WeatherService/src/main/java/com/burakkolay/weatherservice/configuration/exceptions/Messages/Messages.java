package com.burakkolay.weatherservice.configuration.exceptions.Messages;

public class Messages {
    public static class User{
        public static final String CityAlreadyExists= "CITY_ALREADY_EXITS";
        public static String UserCityNotExists= "USER_DOESNT_HAVE_CITY";
        public static final String UserAlreadyExists= "USER_ALREADY_EXITS";
    }
    public static class Weather{
        public static final String CityNotFound = "CITY_NOT_FOUND";
    }
}
