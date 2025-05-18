package com.example.EcoSort;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.EcoSort.models.RankingSemanalResponse;
import java.util.List;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.RankingViewHolder> {
    private final List<RankingSemanalResponse.RankingSemanalUser> ranking;

    public RankingAdapter(List<RankingSemanalResponse.RankingSemanalUser> ranking) {
        this.ranking = ranking;
    }

    @NonNull
    @Override
    public RankingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ranking, parent, false);
        return new RankingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RankingViewHolder holder, int position) {
        RankingSemanalResponse.RankingSemanalUser user = ranking.get(position);
        holder.tvPosition.setText(String.valueOf(position + 1));
        holder.tvUsername.setText(user.getNombre_usuario());
        holder.tvPoints.setText(String.valueOf(user.getPuntos_semana()));
        holder.tvLevel.setText(user.getNivel_nombre());
    }

    @Override
    public int getItemCount() {
        return ranking.size();
    }

    static class RankingViewHolder extends RecyclerView.ViewHolder {
        TextView tvPosition, tvUsername, tvPoints, tvLevel;

        public RankingViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPosition = itemView.findViewById(R.id.tvPosition);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvPoints = itemView.findViewById(R.id.tvPoints);
            tvLevel = itemView.findViewById(R.id.tvLevel);
        }
    }
}