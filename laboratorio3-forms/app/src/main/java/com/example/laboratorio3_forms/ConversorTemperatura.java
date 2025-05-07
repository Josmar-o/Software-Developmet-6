package com.example.laboratorio3_forms;

import static com.example.laboratorio3_forms.R.*;

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

public class ConversorTemperatura extends AppCompatActivity {

    EditText inputUsuario;
    TextView resultado;
    Button calcularCtoF,calcularFtoC, mainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(layout.activity_conversor_temperatura);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        inputUsuario = findViewById(R.id.inputUsuario);
        resultado = findViewById(R.id.resultado);
        calcularCtoF = findViewById(R.id.calcularKmToM);
        calcularFtoC = findViewById(id.calcularMtoKm);

        //            Hacer un boton que regrese al menu
        mainActivity = findViewById(R.id.regresar);

        mainActivity.setOnClickListener(v -> {
            startActivity(new Intent(ConversorTemperatura.this, MainActivity.class));
        });

        //Programa
        calcularCtoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputUsuario.getText().toString().trim();

                if (input.isEmpty()) {
                    Toast.makeText(ConversorTemperatura.this, "El campo no puede estar vacío", Toast.LENGTH_SHORT).show();
                    inputUsuario.setText("");
                    resultado.setText("");
                    return;
                }

                double celsius;
                try {
                    celsius = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    Toast.makeText(ConversorTemperatura.this, "Ingresa solo números válidos", Toast.LENGTH_SHORT).show();
                    inputUsuario.setText("");
                    resultado.setText("");
                    return;
                }

                double fahrenheit = (celsius * 1.8) + 32;
                resultado.setText(String.format("%.2f °F", fahrenheit));
            }
        });

        calcularFtoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputUsuario.getText().toString().trim();

                if (input.isEmpty()) {
                    Toast.makeText(ConversorTemperatura.this, "El campo no puede estar vacío", Toast.LENGTH_SHORT).show();
                    inputUsuario.setText("");
                    resultado.setText("");
                    return;
                }

                double fahrenheit;
                try {
                    fahrenheit = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    Toast.makeText(ConversorTemperatura.this, "Ingresa solo números válidos", Toast.LENGTH_SHORT).show();
                    inputUsuario.setText("");
                    resultado.setText("");
                    return;
                }

                double celsius = (fahrenheit - 32) * 5 / 9;
                resultado.setText(String.format("%.2f °C", celsius));
            }
        });



    }
}
