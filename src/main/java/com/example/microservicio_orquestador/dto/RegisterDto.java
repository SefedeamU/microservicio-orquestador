package com.example.microservicio_orquestador.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterDto {
    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    // Getters and Setters
}