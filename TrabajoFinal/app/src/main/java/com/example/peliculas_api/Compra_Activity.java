package com.example.peliculas_api;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Compra_Activity extends AppCompatActivity {

    Spinner spinnerCine;
    Spinner spinnerHora;
    Spinner spinnerButaca;
    Button buttonCompra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compra);

        spinnerCine = (Spinner)findViewById(R.id.spinnerCine);
        spinnerHora = (Spinner)findViewById(R.id.spinnerHora);
        spinnerButaca = (Spinner)findViewById(R.id.spinnerButaca);
        buttonCompra= (Button)findViewById(R.id.buttonCompra);

        buttonCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screenChanger = new Intent(getBaseContext(),
                        ConfirmarCompra.class
                );

                startActivity(screenChanger);
            }
        });

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.cines, android.R.layout.simple_spinner_item);
        spinnerCine.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.horas, android.R.layout.simple_spinner_item);
        spinnerHora.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.butacas, android.R.layout.simple_spinner_item);
        spinnerButaca.setAdapter(adapter);

    }
}