package com.burakkolay.weatherservice.business.rules;

import com.burakkolay.weatherservice.configuration.exceptions.BusinessException;
import com.burakkolay.weatherservice.configuration.exceptions.Messages.Messages;
import com.burakkolay.weatherservice.entities.User;
import com.burakkolay.weatherservice.entities.Weather;
import com.burakkolay.weatherservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserBusinessRules {
    private final UserRepository repository;

    public User getUserPrincipals(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails userDetails) {
            return repository.findByUsername(userDetails.getUsername()).orElseThrow();
        }else {
            throw new RuntimeException("Kullanıcı Bulunamadı");
        }
    }

    public void checkIfCityExists(String city){
        User user = getUserPrincipals();
        ArrayList<String> cityByUsername = repository.findCityByUsername(user.getUsername());
        if(cityByUsername.get(0).toLowerCase().contains(city.toLowerCase()))
            throw new BusinessException(Messages.User.CityAlreadyExists);
    }
}
