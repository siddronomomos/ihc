package com.example.EcoSort.models;

public class LoginResponse {
    private String status;
    private String token;
    private int userId;

    public String getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }

    public int getUserId() {
        return userId;
    }
}
