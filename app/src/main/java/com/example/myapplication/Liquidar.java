package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Liquidar extends AppCompatActivity {

    private TextView nombre_tx, cargo_tx,sueldo_tx,dia_tx, sueldo_neto_tx, valor_dia, pension, salud, descuento;

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
        descuento = findViewById(R.id.descuento1);
        pension = findViewById(R.id.pension1);
        salud = findViewById(R.id.salud1);


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

        double pension_dt = getIntent().getDoubleExtra("pension", 0.0);
        pension.setText(String.valueOf("Por la pension 4%: " + pension_dt));

        double salud_dt = getIntent().getDoubleExtra("salud", 0.0);
        salud.setText(String.valueOf("Por la salud 4%: " + salud_dt));

        double descuento_dt = getIntent().getDoubleExtra("descuento", 0.0);
        descuento.setText(String.valueOf("Por el descuento 3%: " + descuento_dt));
    }

    public void inicio (View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}