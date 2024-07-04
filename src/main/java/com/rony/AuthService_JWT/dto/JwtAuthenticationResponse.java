package com.rony.AuthService_JWT.dto;

public record JwtAuthenticationResponse(String accessToken,String tokenType) {
    public JwtAuthenticationResponse(String accessToken) {
        this(accessToken,"Bearer");
    }
}
