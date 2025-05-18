package com.example.EcoSort.models;

public class RegisterRequest {
    private final String nombre_usuario;
    private final String email;
    private final String password;

    public RegisterRequest(String nombre_usuario, String email, String password) {
        this.nombre_usuario = nombre_usuario;
        this.email = email;
        this.password = password;
    }
}
