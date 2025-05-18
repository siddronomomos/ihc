package com.example.EcoSort;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ConsejosAdapter extends RecyclerView.Adapter<ConsejosAdapter.ConsejoViewHolder> {
    private final List<Consejo> consejos;

    public ConsejosAdapter(List<Consejo> consejos) {
        this.consejos = consejos;
    }

    @NonNull
    @Override
    public ConsejoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_consejo, parent, false);
        return new ConsejoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConsejoViewHolder holder, int position) {
        Consejo consejo = consejos.get(position);
        holder.tvTitulo.setText(consejo.getTitulo());
        holder.tvDescripcion.setText(consejo.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return consejos.size();
    }

    static class ConsejoViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo, tvDescripcion;

        public ConsejoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
        }
    }
}