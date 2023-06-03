package com.burakkolay.weatherservice.repository;

import java.util.Optional;
import com.burakkolay.weatherservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

}
