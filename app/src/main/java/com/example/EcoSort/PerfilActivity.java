package com.example.EcoSort;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.EcoSort.models.PerfilResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilActivity extends AppCompatActivity {
    private TextView tvUsername, tvEmail, tvPuntos, tvNivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tvUsername = findViewById(R.id.tvUsername);
        tvEmail = findViewById(R.id.tvEmail);
        tvPuntos = findViewById(R.id.tvPuntos);
        tvNivel = findViewById(R.id.tvNivel);

        cargarDatosPerfil();
    }

    private void cargarDatosPerfil() {
        ApiClient.getClient(this).getPerfilUsuario().enqueue(new Callback<PerfilResponse>() {
            @Override
            public void onResponse(Call<PerfilResponse> call, Response<PerfilResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    PerfilResponse perfil = response.body();
                    tvUsername.setText(perfil.getNombre_usuario());
                    tvEmail.setText(perfil.getEmail());
                    tvPuntos.setText(String.valueOf(perfil.getPuntos()));
                    tvNivel.setText(perfil.getNivel_nombre());
                }
            }

            @Override
            public void onFailure(Call<PerfilResponse> call, Throwable t) {
                // Manejar error
            }
        });
    }
}