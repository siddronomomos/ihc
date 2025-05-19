package com.example.EcoSort;

import com.example.EcoSort.models.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {
    @POST("login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET("test")
    Call<ApiResponse> testConnection();

    @POST("usuarios")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);

    @GET("estadisticas")
    Call<EstadisticasResponse> getEstadisticas();

    @GET("perfil")
    Call<PerfilResponse> getPerfilUsuario();

    @GET("ranking/semanal")
    Call<RankingSemanalResponse> getRankingSemanal();

    @GET("historial")
    Call<HistorialResponse> getHistorial();

    @POST("historial")
    Call<ReciclajeResponse> registrarReciclaje(@Body ReciclajeRequest request);
}