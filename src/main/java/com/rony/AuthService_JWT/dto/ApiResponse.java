package com.rony.AuthService_JWT.dto;

public record ApiResponse(
    Boolean success,
    String message
) { }
