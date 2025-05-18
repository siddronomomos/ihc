package com.example.EcoSort;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.example.EcoSort.models.HistorialResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistorialActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HistorialAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        recyclerView = findViewById(R.id.recyclerViewHistorial);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cargarHistorial();
    }

    private void cargarHistorial() {
        ApiClient.getClient(this).getHistorial().enqueue(new Callback<HistorialResponse>() {
            @Override
            public void onResponse(Call<HistorialResponse> call, Response<HistorialResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<HistorialResponse.HistorialItem> historial = response.body().getData();
                    adapter = new HistorialAdapter(historial);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<HistorialResponse> call, Throwable t) {
                // Manejar error
            }
        });
    }
}