package com.rony.AuthService_JWT.dto;

public record LoginRequestDTO(
    String email,
    String password
){ }
