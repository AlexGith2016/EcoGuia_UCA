package com.uca.ecoguiauca.Fragments;

import android.content.Context;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uca.ecoguiauca.Models.Patogeno;
import com.uca.ecoguiauca.Models.RvPatogenoAdapter;
import com.uca.ecoguiauca.R;

import java.util.ArrayList;

public class GaleriaFragment extends DialogFragment {
    private View view;
    private TextView txtTituloPatogeno;
    private ImageView ivImagenPatogeno;
    private RecyclerView rvGaleria;
    private ArrayList<Patogeno> list;
    private RvPatogenoAdapter adapter;

    public GaleriaFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_galeria, container, false);
        txtTituloPatogeno = view.findViewById(R.id.txtTituloPatogeno);
        ivImagenPatogeno = view.findViewById(R.id.ivTituloPatogeno);
        rvGaleria = view.findViewById(R.id.rvGaleria);
        rvGaleria.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        ivImagenPatogeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        list = new Patogeno().listarPatogenos();

        adapter = new RvPatogenoAdapter(list, new RvPatogenoAdapter.OnClickRecycler() {
            @Override
            public void OnClickItemRecycler(Patogeno patogeno) {
                Glide.with(getContext()).load(patogeno.getImagen()).into(ivImagenPatogeno);
                txtTituloPatogeno.setText(patogeno.getNombrePatogeno());
            }
        });
        /*rvGaleria.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.onDraw(c, parent, state);
                int divLeft = 32;
                int divRight = parent.getWidth() - 32;
                for (int i = 0; i < parent.getChildCount(); i++) {
                    if(i != parent.getChildCount()-1){
                        View child = parent.getChildAt(i);
                        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)child.getLayoutParams();

                        parent.getForegroundGravity();
                    }
                }
            }
        });*/
        rvGaleria.setAdapter(adapter);
        return view;
    }
}
