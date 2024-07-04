package com.rony.AuthService_JWT.dto;

public record SignUpRequestDTO(
    String username,
    String email,
    String password,
    String phone
) { }
