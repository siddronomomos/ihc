package com.example.EcoSort;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.EcoSort.models.HistorialResponse;
import java.util.List;

public class HistorialAdapter extends RecyclerView.Adapter<HistorialAdapter.HistorialViewHolder> {
    private final List<HistorialResponse.HistorialItem> historial;

    public HistorialAdapter(List<HistorialResponse.HistorialItem> historial) {
        this.historial = historial;
    }

    @NonNull
    @Override
    public HistorialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_historial, parent, false);
        return new HistorialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistorialViewHolder holder, int position) {
        HistorialResponse.HistorialItem item = historial.get(position);
        holder.tvMaterial.setText(item.getTipo_material());
        holder.tvProducto.setText(item.getTipo_producto());
        holder.tvPeso.setText(String.format("%.2f kg", item.getPeso_kg()));
        holder.tvPuntos.setText(String.valueOf(item.getPuntos_obtenidos()));
        holder.tvFecha.setText(item.getFecha());
    }

    @Override
    public int getItemCount() {
        return historial.size();
    }

    static class HistorialViewHolder extends RecyclerView.ViewHolder {
        TextView tvMaterial, tvProducto, tvPeso, tvPuntos, tvFecha;

        public HistorialViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMaterial = itemView.findViewById(R.id.tvMaterial);
            tvProducto = itemView.findViewById(R.id.tvProducto);
            tvPeso = itemView.findViewById(R.id.tvPeso);
            tvPuntos = itemView.findViewById(R.id.tvPuntos);
            tvFecha = itemView.findViewById(R.id.tvFecha);
        }
    }
}