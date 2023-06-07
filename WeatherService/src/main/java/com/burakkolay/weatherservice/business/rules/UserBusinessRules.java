package com.burakkolay.weatherservice.business.rules;

import com.burakkolay.weatherservice.configuration.exceptions.BusinessException;
import com.burakkolay.weatherservice.configuration.exceptions.Messages.Messages;
import com.burakkolay.weatherservice.entities.User;
import com.burakkolay.weatherservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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

    public void checkIfCityExists(String city,User user){
        ArrayList<String> cities = user.getCities();
        if(cities == null)
            return;
        for(String userCity : cities){
            if(userCity.equalsIgnoreCase(city))
                throw new BusinessException(Messages.User.CityAlreadyExists);
        }
    }
    public void checkIfUserCityNotExists(User user){
        ArrayList<String> cities = user.getCities();
        if(cities==null)
            throw new BusinessException(Messages.User.UserCityNotExists);
    }
}
