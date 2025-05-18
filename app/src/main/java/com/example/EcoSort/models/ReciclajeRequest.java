package com.example.EcoSort.models;

public class ReciclajeRequest {
    private String tipo_material;
    private String tipo_producto;
    private double peso_kg;

    public ReciclajeRequest(String tipo_material, String tipo_producto, double peso_kg) {
        this.tipo_material = tipo_material;
        this.tipo_producto = tipo_producto;
        this.peso_kg = peso_kg;
    }
}