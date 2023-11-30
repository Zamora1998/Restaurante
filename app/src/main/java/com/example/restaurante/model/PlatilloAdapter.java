package com.example.restaurante.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurante.R;

import java.util.List;

public class PlatilloAdapter extends RecyclerView.Adapter<PlatilloAdapter.PlatilloViewHolder> {

    private List<Menu> platillos;

    public PlatilloAdapter(List<Menu> platillos) {
        this.platillos = platillos;
    }

    @NonNull
    @Override
    public PlatilloViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_platillo, parent, false);
        return new PlatilloViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlatilloViewHolder holder, int position) {
        Menu platillo = platillos.get(position);

        //holder.textViewPlatilloID.setText("Platillo ID: " + platillo.getPlatilloID());
        holder.textViewNombre.setText("Nombre: " + platillo.getNombre());
        holder.textViewCosto.setText("Costo: " + platillo.getCosto());
        holder.textViewCategoria.setText("Categoria: " + platillo.getCategoriaNombre());
        holder.textViewEstado.setText("Estado: " + platillo.getEstadoDescripcion());


    }

    @Override
    public int getItemCount() {
        return platillos.size();
    }

    static class PlatilloViewHolder extends RecyclerView.ViewHolder {
        //TextView textViewPlatilloID;
        TextView textViewNombre;
        TextView textViewCosto;
        TextView textViewCategoria;
        TextView textViewEstado;


        PlatilloViewHolder(@NonNull View itemView) {
            super(itemView);
            //textViewPlatilloID = itemView.findViewById(R.id.textViewPlatilloID);
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
            textViewCosto = itemView.findViewById(R.id.textViewCosto);
            textViewCategoria = itemView.findViewById(R.id.textViewCategoria);
            textViewEstado = itemView.findViewById(R.id.textViewEstado);

        }
    }
}
