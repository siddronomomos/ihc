package com.example.EcoSort.models;

import java.util.List;

public class RankingSemanalResponse {
    private String status;
    private List<RankingSemanalUser> data;

    public static class RankingSemanalUser {
        private int id_usuario;
        private String nombre_usuario;
        private int puntos_semana;
        private int nivel;
        private String nivel_nombre;

        // Getters y Setters
        public int getId_usuario() { return id_usuario; }
        public String getNombre_usuario() { return nombre_usuario; }
        public int getPuntos_semana() { return puntos_semana; }
        public int getNivel() { return nivel; }
        public String getNivel_nombre() { return nivel_nombre; }
    }

    public String getStatus() { return status; }
    public List<RankingSemanalUser> getData() { return data; }
}