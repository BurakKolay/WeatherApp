package com.burakkolay.weatherservice.configuration.exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
