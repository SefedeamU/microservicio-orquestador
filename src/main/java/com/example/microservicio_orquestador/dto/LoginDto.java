package com.example.microservicio_orquestador.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginDto {
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;

    // Getters and Setters
}