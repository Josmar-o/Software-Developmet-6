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

public class CalculadoraEdad extends AppCompatActivity {

    EditText anioUsuario;
    TextView resultado;
    Button calcular, mainActivity;

    int anioActual = 2025;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora_edad);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        anioUsuario = findViewById(R.id.inputUsuario);
        resultado = findViewById(R.id.resultado);
        calcular = findViewById(R.id.calcular);

        //            Hacer un boton que regrese al menu
        mainActivity = findViewById(R.id.regresar);

        mainActivity.setOnClickListener(v -> {
            startActivity(new Intent(CalculadoraEdad.this, MainActivity.class));
        });

        //Programa

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = anioUsuario.getText().toString().trim();

                // Validar que no esté vacío
                if (input.isEmpty()) {
                    Toast.makeText(CalculadoraEdad.this, "Por favor ingresa un año", Toast.LENGTH_SHORT).show();
                    anioUsuario.setText("");
                    resultado.setText("");
                    return;
                }

                // Validar que tenga máximo 4 cifras
                if (input.length() > 4) {
                    Toast.makeText(CalculadoraEdad.this, "El año no puede tener más de 4 dígitos", Toast.LENGTH_SHORT).show();
                    anioUsuario.setText("");
                    resultado.setText("");
                    return;
                }

                // Validar que solo contenga dígitos
                if (!input.matches("\\d+")) {
                    Toast.makeText(CalculadoraEdad.this, "Solo se permiten números", Toast.LENGTH_SHORT).show();
                    anioUsuario.setText("");
                    resultado.setText("");
                    return;
                }

                int anioNacimiento = Integer.parseInt(input);

                // Validar que no sea mayor al año actual
                if (anioNacimiento > anioActual) {
                    Toast.makeText(CalculadoraEdad.this, "El año no puede ser mayor a " + anioActual, Toast.LENGTH_SHORT).show();
                    anioUsuario.setText("");
                    resultado.setText("");
                    return;
                }

                int edad = anioActual - anioNacimiento;
                resultado.setText("Tienes " + edad + " años.");
            }


        });
    }
}
