package com.burakkolay.weatherservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.burakkolay.weatherservice.entities.User;
import com.burakkolay.weatherservice.entities.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    @Query("SELECT cities from User where username=:username")
    ArrayList<String> findCityByUsername(String username);

}
