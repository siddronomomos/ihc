package com.example.EcoSort.models;

public class PerfilResponse {
    private String nombre_usuario;
    private String email;
    private int puntos;
    private String nivel_nombre;

    // Getters
    public String getNombre_usuario() { return nombre_usuario; }
    public String getEmail() { return email; }
    public int getPuntos() { return puntos; }
    public String getNivel_nombre() { return nivel_nombre; }

    public void setNombre_usuario(String nombre_usuario) { this.nombre_usuario = nombre_usuario; }
    public void setEmail(String email) { this.email = email; }
    public void setPuntos(int puntos) { this.puntos = puntos; }
    public void setNivel_nombre(String nivel_nombre) { this.nivel_nombre = nivel_nombre; }
}