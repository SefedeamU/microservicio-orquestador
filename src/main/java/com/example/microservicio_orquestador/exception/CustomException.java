package com.example.microservicio_orquestador.exception;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}