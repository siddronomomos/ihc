package com.example.EcoSort.models;

import java.util.List;

public class RankingResponse {
    private String status;
    private List<RankingUser> data;

    public static class RankingUser {
        private int id_usuario;
        private String nombre_usuario;
        private int puntos_totales;
        private int nivel;
        private String nivel_nombre;

        public int getId_usuario() { return id_usuario; }
        public String getNombre_usuario() { return nombre_usuario; }
        public int getPuntos_totales() { return puntos_totales; }
        public int getNivel() { return nivel; }
        public String getNivel_nombre() { return nivel_nombre; }

        public RankingUser(int id_usuario, String nombre_usuario, int puntos_totales, int nivel, String nivel_nombre) {
            this.id_usuario = id_usuario;
            this.nombre_usuario = nombre_usuario;
            this.puntos_totales = puntos_totales;
            this.nivel = nivel;
            this.nivel_nombre = nivel_nombre;
        }

    }
    public String getStatus() { return status; }
    public List<RankingUser> getData() { return data; }

    public RankingResponse(String status, List<RankingUser> data) {
        this.status = status;
        this.data = data;
    }
}
