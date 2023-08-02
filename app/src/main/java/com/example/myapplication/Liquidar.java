package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Liquidar extends AppCompatActivity {

    private TextView nombre_tx, cargo_tx,sueldo_tx,dia_tx, sueldo_neto_tx, valor_dia;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquidar);

        nombre_tx = findViewById(R.id.name);
        cargo_tx = findViewById(R.id.cargo);
        dia_tx = findViewById(R.id.dia);
        sueldo_tx = findViewById(R.id.presu);
        sueldo_neto_tx = findViewById(R.id.subtotal);
        valor_dia = findViewById(R.id.valor_dia);


        String name = getIntent().getStringExtra("nombre");
        String apellidos = getIntent().getStringExtra("apellidos");
        nombre_tx.setText(name + " " + apellidos);

        String cargo = getIntent().getStringExtra("cargo");
        cargo_tx.setText(cargo);

        String dia = getIntent().getStringExtra("dia");
        dia_tx.setText(dia);

        String presupuesto = getIntent().getStringExtra("sueldo");
        sueldo_tx.setText(presupuesto);

        double sueldoNeto = getIntent().getDoubleExtra("sueldo_neto", 0.0);
        sueldo_neto_tx.setText(String.valueOf(sueldoNeto));

        double valor_dias = getIntent().getDoubleExtra("salario_bruto", 0.0);
        valor_dia.setText(String.valueOf(valor_dias));
    }

    public void inicio (View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}