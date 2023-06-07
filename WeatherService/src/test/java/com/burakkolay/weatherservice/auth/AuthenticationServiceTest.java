package com.burakkolay.weatherservice.auth;

import com.burakkolay.commonpackage.kafka.producer.KafkaProducer;
import com.burakkolay.weatherservice.configuration.exceptions.BusinessException;
import com.burakkolay.weatherservice.entities.Role;
import com.burakkolay.weatherservice.entities.User;
import com.burakkolay.weatherservice.repository.UserRepository;
import com.burakkolay.weatherservice.security.JwtService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

    @Mock
    private UserRepository repository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private JwtService jwtService;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private KafkaProducer producer;

    @InjectMocks
    private AuthenticationService authenticationService;

    @Test
    void shouldRegister() {
        RegisterRequest request = new RegisterRequest("burak", "kolay", "burak", "12345");
        User user = new User(1L, "burak", "kolay", "burak", "12345", null, Role.ROLE_USER);
        Mockito.when(repository.existsByUsername(Mockito.any())).thenReturn(false);
        Mockito.when(passwordEncoder.encode(Mockito.any())).thenReturn(user.getPassword());
        Mockito.when(repository.save(Mockito.any())).thenReturn(user);
        Mockito.when(jwtService.generateToken(Mockito.any())).thenReturn("12345");
        AuthenticationResponse register = authenticationService.register(request);
        Assertions.assertEquals(register.getToken(), "12345");
    }

    @Test
    void shouldNotRegister() {
        RegisterRequest request = new RegisterRequest("burak", "kolay", "burak", "12345");
        Mockito.when(repository.existsByUsername(Mockito.any())).thenReturn(true);
        Assertions.assertThrows(BusinessException.class, () -> authenticationService.register(request));
    }

    @Test
    void authenticate() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("burak", "kolay");
        Authentication authentication = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword());
        User user = new User(1L, "burak", "kolay", "burak", "12345", null, Role.ROLE_USER);
        Mockito.when(authenticationManager.authenticate(Mockito.any())).thenReturn(authentication);
        Mockito.when(repository.findByUsername(Mockito.any())).thenReturn(Optional.of(user));
        Mockito.when(jwtService.generateToken(Mockito.any())).thenReturn("12345");
        AuthenticationResponse authenticate = authenticationService.authenticate(authenticationRequest);
        Assertions.assertEquals(authenticate.getToken(),"12345");
    }
}