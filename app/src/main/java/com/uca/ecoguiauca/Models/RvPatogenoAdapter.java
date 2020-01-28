package com.uca.ecoguiauca.Models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.uca.ecoguiauca.R;

import java.util.ArrayList;

public class RvPatogenoAdapter extends RecyclerView.Adapter<RvPatogenoAdapter.MyViewHolder> {
    private ArrayList<Patogeno> list;
    private OnClickRecycler listener;

    public RvPatogenoAdapter(ArrayList<Patogeno> list, OnClickRecycler listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RvPatogenoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptador_patogeno, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RvPatogenoAdapter.MyViewHolder holder, int position) {
        Patogeno patogeno = list.get(position);
        holder.bind(patogeno, listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public interface OnClickRecycler{
        void OnClickItemRecycler(Patogeno patogeno);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView ivGaleria;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGaleria = itemView.findViewById(R.id.ivGaleria);
        }

        public void bind(final Patogeno p, final OnClickRecycler listener){
            Glide.with(ivGaleria.getContext()).load(p.getImagen()).into(ivGaleria);
            ivGaleria.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "cargar imagen grande",Toast.LENGTH_SHORT).show();
                    listener.OnClickItemRecycler(p);
                }
            });
        }
    }
}
