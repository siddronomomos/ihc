package com.example.EcoSort;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.EcoSort.models.PerfilResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilActivity extends AppCompatActivity {
    private TextView tvUsername;
    private TextView tvPuntosLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        // Inicializar vistas
        tvUsername = findViewById(R.id.tvUsername);
        tvPuntosLabel = findViewById(R.id.tvPuntosLabel);
        ImageButton btnBack = findViewById(R.id.btnBack);

        // Configurar botón de regreso
        btnBack.setOnClickListener(v -> finish());

        // Cargar datos del perfil
        cargarDatosPerfil();
    }

    private void cargarDatosPerfil() {
        ApiClient.getClient(this).getPerfilUsuario().enqueue(new Callback<PerfilResponse>() {
            @Override
            public void onResponse(Call<PerfilResponse> call, Response<PerfilResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    PerfilResponse perfil = response.body();
                    tvUsername.setText(perfil.getNombre_usuario());
                    tvPuntosLabel.setText("TOTAL DE PUNTOS: " + perfil.getPuntos());
                }
            }

            @Override
            public void onFailure(Call<PerfilResponse> call, Throwable t) {
                // Manejar error
            }
        });
    }
}