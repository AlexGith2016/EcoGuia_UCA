package com.uca.ecoguiauca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class Calculadora_Producto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora__producto);
        Toolbar toolbar = findViewById(R.id.toolbarC);
        setSupportActionBar(toolbar);
        setTitle("Calculadora de Productos");

        int number1= getIntent().getIntExtra("number1", 0);
        int number2 = getIntent().getIntExtra("number2", 0);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
