package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

        private EditText nombre, apellido, cargo, sueldo, dia;
        private CheckBox checkDescuento, checkSalud, checkPension;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        cargo = findViewById(R.id.cargo);
        sueldo = findViewById(R.id.sueldo);
        dia = findViewById(R.id.dia1);

        checkDescuento = findViewById(R.id.descuento);
        checkSalud = findViewById(R.id.salud);
        checkPension = findViewById(R.id.pension);
    }

    public void inicio (View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void liquidar (View view) {

        Intent i = new Intent(this, Liquidar.class);

        double sueldoInicial = Double.parseDouble(sueldo.getText().toString());


        boolean descuento = checkDescuento.isChecked();
        boolean salud = checkSalud.isChecked();
        boolean pension = checkPension.isChecked();


        double porcentajeDescuento = 0;
        if (descuento) {
            porcentajeDescuento += 3;
        }
        if (salud) {
            porcentajeDescuento += 4;
        }
        if (pension) {
            porcentajeDescuento += 4;
        }

        double descuentoObtenido = sueldoInicial * (porcentajeDescuento / 100);

        double sueldoNeto = sueldoInicial - descuentoObtenido;

        //calcular el valor por dia

        double dias = Double.parseDouble(dia.getText().toString());

        double valor_dia = sueldoNeto / dias;



        i.putExtra("nombre", nombre.getText().toString());
        i.putExtra("apellidos", apellido.getText().toString());
        i.putExtra("cargo", cargo.getText().toString());
        i.putExtra("sueldo", sueldo.getText().toString());
        i.putExtra("dia", dia.getText().toString());
        i.putExtra("sueldo_neto", sueldoNeto);
        i.putExtra("valor_dia", valor_dia);

        startActivity(i);
    }
}