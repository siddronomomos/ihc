package com.example.EcoSort;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.EcoSort.models.EstadisticasResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Principal extends AppCompatActivity {
    private TextView tvUsername, tvPuntos;
    private ImageView ivProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        // Configurar elementos de la UI
        ivProfile = findViewById(R.id.ivProfile);

        // Botones
        CardView btnMapa = findViewById(R.id.btnMapa);
        CardView btnHistorial = findViewById(R.id.btnHistorial);
        CardView btnConsejos = findViewById(R.id.btnConsejos);
        CardView btnReciclar = findViewById(R.id.btnReciclar);

        // Configurar listeners
        ivProfile.setOnClickListener(v -> {
            Intent intent = new Intent(Principal.this, PerfilActivity.class);
            startActivity(intent);
        });

        btnMapa.setOnClickListener(v -> {
            Intent intent = new Intent(Principal.this, MapaActivity.class);
            startActivity(intent);
        });

        btnHistorial.setOnClickListener(v -> {
            Intent intent = new Intent(Principal.this, HistorialActivity.class);
            startActivity(intent);
        });

        btnConsejos.setOnClickListener(v -> {
            Intent intent = new Intent(Principal.this, ConsejosActivity.class);
            startActivity(intent);
        });

        btnReciclar.setOnClickListener(v -> {
            Intent intent = new Intent(Principal.this, ReciclarActivity.class);
            startActivity(intent);
        });

    }
}