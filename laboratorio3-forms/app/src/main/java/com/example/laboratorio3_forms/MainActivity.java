package com.example.laboratorio3_forms;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button actividadEdad, actividadTemp,actividadNombre,actividadDosNum,actividadDesto,actividadMult,actividadValidEdad,actividadRect,actividadKmToMil,actividadValidCont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        actividadEdad = findViewById(R.id.actividadEdad);
        actividadTemp = findViewById(R.id.actividadTemp);
        actividadNombre = findViewById(R.id.actividadNombre);
        actividadDosNum = findViewById(R.id.actividadDosNum);
        actividadDesto = findViewById(R.id.actividadDesto);
        actividadMult = findViewById(R.id.actividadMult);
        actividadValidEdad = findViewById(R.id.actividadValidEdad);
        actividadRect = findViewById(R.id.actividadRect);
        actividadKmToMil = findViewById(R.id.actividadKmToMil);
        actividadValidCont = findViewById(R.id.actividadValidCont);

        actividadEdad.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, CalculadoraEdad.class));
        });

        actividadTemp.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ConversorTemperatura.class));
        });

        actividadNombre.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ValidacionNombre.class));
        });

        actividadDosNum.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SumaDosNumeros.class));
        });

        actividadDesto.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, CalculadoraDescuento.class));
        });

        actividadMult.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MultiplicadorDeNumeros.class));
        });

        actividadValidEdad.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ValidacionDeEdad.class));
        });

        actividadRect.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AreaDeRectangulo.class));
        });

        actividadKmToMil.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ConversorKmToMillas.class));
        });

        actividadValidCont.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, VerificacionContrasena.class));
        });



    }
}