package com.burakkolay.weatherservice.auth;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @Column(length = 100,nullable = false)
    private String firstName;
    @Column(length = 100,nullable = false)
    private String lastName;
    @Column(length = 100,unique = true,nullable = false)
    private String username;
    @Column(length = 100,nullable = false)
    @Size(min = 5,message = "Your password must be a minimum of 5 characters")
    private String password;
}
