package com.impact.impact.app.securityConfig.JWT;

public class AuthenticationException extends RuntimeException{
    public AuthenticationException(String message, Throwable cause){
        super(message,cause);
    }
}
