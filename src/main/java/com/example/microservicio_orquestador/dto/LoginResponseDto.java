package com.example.microservicio_orquestador.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponseDto {
    @JsonProperty("user")
    private RegisterDto user;

    @JsonProperty("token")
    private String token;

    // Getters and Setters
}