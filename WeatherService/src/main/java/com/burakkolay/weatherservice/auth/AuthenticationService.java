package com.burakkolay.weatherservice.auth;

import com.burakkolay.weatherservice.configuration.exceptions.BusinessException;
import com.burakkolay.weatherservice.configuration.exceptions.Messages.Messages;
import com.burakkolay.weatherservice.entities.Role;
import com.burakkolay.weatherservice.repository.UserRepository;
import com.burakkolay.weatherservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import com.burakkolay.weatherservice.entities.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder  passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        if(repository.existsByUsername(request.getUsername()))
            throw new BusinessException(Messages.User.UserAlreadyExists);
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .build();
        repository.save(user);
        var jwtToken =jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())
        );
        var user = repository.findByUsername(request.getUsername()).orElseThrow();
        var jwtToken =jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
