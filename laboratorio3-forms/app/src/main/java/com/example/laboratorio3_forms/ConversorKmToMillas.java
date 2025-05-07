package com.example.laboratorio3_forms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConversorKmToMillas extends AppCompatActivity {
    EditText inputUsuario;
    TextView resultado;
    Button calcularKmToM,calcularMtoKm, mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_conversor_km_to_millas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputUsuario = findViewById(R.id.inputUsuario);
        resultado = findViewById(R.id.resultado);
        calcularKmToM = findViewById(R.id.calcularKmToM);
        calcularMtoKm = findViewById(R.id.calcularMtoKm);

        //            Hacer un boton que regrese al menu
        mainActivity = findViewById(R.id.regresar);

        mainActivity.setOnClickListener(v -> {
            startActivity(new Intent(ConversorKmToMillas.this, MainActivity.class));
        });

        // Kilómetros a Millas
        calcularKmToM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputUsuario.getText().toString().trim();

                if (input.isEmpty()) {
                    Toast.makeText(ConversorKmToMillas.this, "El campo no puede estar vacío", Toast.LENGTH_SHORT).show();
                    inputUsuario.setText("");
                    resultado.setText("");
                    return;
                }

                double kilometros;
                try {
                    kilometros = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    Toast.makeText(ConversorKmToMillas.this, "Ingresa solo números válidos", Toast.LENGTH_SHORT).show();
                    inputUsuario.setText("");
                    resultado.setText("");
                    return;
                }

                double millas = kilometros * 0.621371;
                resultado.setText(String.format("%.2f millas", millas));
            }
        });

// Millas a Kilómetros
        calcularMtoKm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputUsuario.getText().toString().trim();

                if (input.isEmpty()) {
                    Toast.makeText(ConversorKmToMillas.this, "El campo no puede estar vacío", Toast.LENGTH_SHORT).show();
                    inputUsuario.setText("");
                    resultado.setText("");
                    return;
                }

                double millas;
                try {
                    millas = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    Toast.makeText(ConversorKmToMillas.this, "Ingresa solo números válidos", Toast.LENGTH_SHORT).show();
                    inputUsuario.setText("");
                    resultado.setText("");
                    return;
                }

                double kilometros = millas / 0.621371;
                resultado.setText(String.format("%.2f km", kilometros));
            }
        });

    }
}