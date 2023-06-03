package com.burakkolay.weatherservice.entities;

public enum Role {
    ROLE_USER,
    ROLE_ADMIN;

    public String getAuthority(){
        return name();
    }
}
