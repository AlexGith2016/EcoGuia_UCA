package com.uca.ecoguiauca.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.uca.ecoguiauca.R;


public class MainAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private int[] imagenes;
    private String[] opciones;

    public MainAdapter(Context context, String[] opciones, int[] imagenes) {
        this.context = context;
        this.imagenes = imagenes;
        this.opciones = opciones;
    }

    @Override
    public int getCount() {
        return opciones.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(layoutInflater == null)
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_main, null);
            convertView.setMinimumHeight(150);
            ImageView imageView = convertView.findViewById(R.id.img_main);
            TextView textView = convertView.findViewById(R.id.text_op_main);
            imageView.setImageResource(imagenes[position]);
            textView.setText(opciones[position]);
        }

        return convertView;
    }
}

