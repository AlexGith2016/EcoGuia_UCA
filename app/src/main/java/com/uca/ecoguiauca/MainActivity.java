package com.uca.ecoguiauca;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.uca.ecoguiauca.Fragments.GaleriaFragment;
import com.uca.ecoguiauca.Models.MainAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GridView gvMain;
    String[] opciones = {"Parametros", "Verificar patogenos", "Cálculos", "Opciones"};
    int[] imagenes = {R.drawable.params1, R.drawable.im1, R.drawable.calc1, R.drawable.opcion1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this,Calculo_patogeno.class);
                intent.putExtra("number1", 70);
                intent.putExtra("number2", 20);
                startActivityForResult(intent, 1);
            }
        });
        gvMain = findViewById(R.id.gvMain);
        MainAdapter mainAdapter= new MainAdapter(MainActivity.this, opciones, imagenes);
        gvMain.setAdapter(mainAdapter);
        gvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(imagenes[position] == R.drawable.im1){
//                    Toast.makeText(getApplicationContext(), "cargar imagenes",Toast.LENGTH_SHORT).show();
                    FragmentManager manager = getSupportFragmentManager();
                    GaleriaFragment galeriaFragment = new GaleriaFragment();
                    galeriaFragment.show(manager, "Galeria");

                }
                if(imagenes[position] == R.drawable.params1){
                    Intent intent = new Intent(MainActivity.this,Calculo_patogeno.class);
                    intent.putExtra("number1", 70);
                    intent.putExtra("number2", 20);
                    startActivityForResult(intent, 1);

                }
                if(imagenes[position] == R.drawable.calc1){
                    Intent intent = new Intent(MainActivity.this,Calculadora_Producto.class);
                    intent.putExtra("number1", 70);
                    intent.putExtra("number2", 20);
                    startActivityForResult(intent, 1);
                }
                if(imagenes[position] == R.drawable.opcion1){
                    Intent intent = new Intent(MainActivity.this,Configuracion.class);
                    intent.putExtra("number1", 70);
                    intent.putExtra("number2", 20);
                    startActivityForResult(intent, 1);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            finish();
            System.exit(0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
