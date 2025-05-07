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

public class ValidacionDeEdad extends AppCompatActivity {
    EditText inputUsuario;
    TextView resultado;
    Button verificarEdad, mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_validacion_de_edad);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputUsuario = findViewById(R.id.inputUsuario);
        resultado = findViewById(R.id.resultado);
        verificarEdad = findViewById(R.id.calcularMtoKm);

        //            Hacer un boton que regrese al menu
        mainActivity = findViewById(R.id.regresar);

        mainActivity.setOnClickListener(v -> {
            startActivity(new Intent(ValidacionDeEdad.this, MainActivity.class));
        });
        verificarEdad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputUsuario.getText().toString().trim();

                if (input.isEmpty()) {
                    resultado.setText("El campo no puede estar vacío");
                    Toast.makeText(ValidacionDeEdad.this, "El campo no puede estar vacío", Toast.LENGTH_SHORT).show();
                    return;
                }

                int edad;
                try {
                    edad = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    resultado.setText("Ingresa una edad válida");
                    Toast.makeText(ValidacionDeEdad.this, "Edad inválida", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (edad < 0) {
                    resultado.setText("La edad no puede ser negativa");
                    Toast.makeText(ValidacionDeEdad.this, "Edad negativa no válida", Toast.LENGTH_SHORT).show();
                } else if (edad >= 18) {
                    resultado.setText("Registro permitido");
                    Toast.makeText(ValidacionDeEdad.this, "Registro permitido", Toast.LENGTH_SHORT).show();
                } else {
                    resultado.setText("Debe ser mayor de edad");
                    Toast.makeText(ValidacionDeEdad.this, "Acceso denegado: menor de edad", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}