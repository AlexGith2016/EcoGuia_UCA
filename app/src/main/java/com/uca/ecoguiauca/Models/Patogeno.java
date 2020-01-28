package com.uca.ecoguiauca.Models;

import com.uca.ecoguiauca.R;

import java.util.ArrayList;

public class Patogeno {
    private String nombrePatogeno;
    private int imagen;

    public Patogeno(String nombrePatogeno, int imagen) {
        this.nombrePatogeno = nombrePatogeno;
        this.imagen = imagen;
    }

    public Patogeno() {
        this.nombrePatogeno = "";
        this.imagen = 0;
    }

    public String getNombrePatogeno() {
        return nombrePatogeno;
    }

    public int getImagen() {
        return imagen;
    }

    public ArrayList<Patogeno> listarPatogenos(){
        Patogeno patogeno;
        ArrayList<Patogeno> list = new ArrayList<Patogeno>();
        String[] opciones = {"Parametros", "Verificar patogenos", "Cálculos", "Opciones"};
        int[] imagenes = {R.drawable.params1, R.drawable.im1, R.drawable.calc1, R.drawable.opcion1};
        for (int i = 0; i < imagenes.length; i++) {
            patogeno = new Patogeno(opciones[i], imagenes[i]);
            list.add(patogeno);
        }
        return list;
    }
}
