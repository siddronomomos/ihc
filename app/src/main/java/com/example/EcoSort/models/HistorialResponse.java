package com.example.EcoSort.models;

import java.util.List;

public class HistorialResponse {
    private String status;
    private List<HistorialItem> data;

    public static class HistorialItem {
        private String tipo_material;
        private String tipo_producto;
        private double peso_kg;
        private int puntos_obtenidos;
        private String fecha;

        // Getters
        public String getTipo_material() { return tipo_material; }
        public String getTipo_producto() { return tipo_producto; }
        public double getPeso_kg() { return peso_kg; }
        public int getPuntos_obtenidos() { return puntos_obtenidos; }
        public String getFecha() { return fecha; }
    }

    public String getStatus() { return status; }
    public List<HistorialItem> getData() { return data; }
}