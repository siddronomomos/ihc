package com.example.EcoSort;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ConsejosActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ConsejosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos);

        recyclerView = findViewById(R.id.recyclerViewConsejos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Consejo> consejos = new ArrayList<>();
        consejos.add(new Consejo("Separa tus residuos", "Divide tus residuos en orgánicos, reciclables y no reciclables para facilitar el proceso."));
        consejos.add(new Consejo("Limpia los envases", "Enjuaga los envases de comida antes de reciclarlos para evitar malos olores."));
        consejos.add(new Consejo("Aplasta las botellas", "Reduce el espacio que ocupan las botellas de plástico aplastándolas antes de tirarlas."));
        consejos.add(new Consejo("Reutiliza bolsas", "Usa las mismas bolsas varias veces para reducir el consumo de plástico."));
        consejos.add(new Consejo("Conoce los puntos limpios", "Identifica los puntos de reciclaje más cercanos a tu ubicación."));

        adapter = new ConsejosAdapter(consejos);
        recyclerView.setAdapter(adapter);
    }
}

class Consejo {
    private final String titulo;
    private final String descripcion;

    public Consejo(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
}