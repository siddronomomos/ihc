package com.example.EcoSort;

import com.example.EcoSort.models.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Header;

public interface ApiService {
    @POST("login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET("test")
    Call<ApiResponse> testConnection();

    @POST("usuarios")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);

    @GET("estadisticas")
    Call<EstadisticasResponse> getEstadisticas();

    @GET("ranking")
    Call<RankingResponse> getRanking();
}
