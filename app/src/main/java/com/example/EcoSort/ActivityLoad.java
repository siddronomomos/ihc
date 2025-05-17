package com.example.EcoSort;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.EcoSort.models.ApiResponse;

public class ActivityLoad extends AppCompatActivity {
    private static final String TAG = "ActivityLoad";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_load);

        testApiConnection();
    }

    private void testApiConnection() {
        ApiClient.getClient(this).testConnection().enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "Conexión a la API exitosa");
                } else {
                    Log.e(TAG, "Error en la conexión a la API");
                    showError("Error al conectar con el servidor");
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e(TAG, "Fallo en la conexión a la API", t);
                showError("Error de conexión: " + t.getMessage());
            }
        });
    }

    private void showError(String message) {
        runOnUiThread(() -> Toast.makeText(this, message, Toast.LENGTH_LONG).show());
    }
}