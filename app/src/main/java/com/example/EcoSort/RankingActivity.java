package com.example.EcoSort;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.example.EcoSort.models.RankingSemanalResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RankingActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RankingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        recyclerView = findViewById(R.id.recyclerViewRanking);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cargarRanking();
    }

    private void cargarRanking() {
        ApiClient.getClient(this).getRankingSemanal().enqueue(new Callback<RankingSemanalResponse>() {
            @Override
            public void onResponse(Call<RankingSemanalResponse> call, Response<RankingSemanalResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<RankingSemanalResponse.RankingSemanalUser> ranking = response.body().getData();
                    adapter = new RankingAdapter(ranking);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<RankingSemanalResponse> call, Throwable t) {
                // Manejar error
            }
        });
    }
}