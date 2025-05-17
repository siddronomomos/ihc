package com.example.EcoSort.models;

public class EstadisticasResponse {
    private String status;
    private EstadisticasData data;

    public static class EstadisticasData {
        private int puntos;
        private int puntos_totales;
        private int nivel;
        private String nivel_nombre;
        private int total_reciclajes;
        private double total_kg_reciclados;

        // Getters
        public int getPuntos() { return puntos; }
        public int getPuntosTotales() { return puntos_totales; }
        public int getNivel() { return nivel; }
        public String getNivelNombre() { return nivel_nombre; }
        public int getTotalReciclajes() { return total_reciclajes; }
        public double getTotalKgReciclados() { return total_kg_reciclados; }
    }

    public String getStatus() { return status; }
    public EstadisticasData getData() { return data; }
}

