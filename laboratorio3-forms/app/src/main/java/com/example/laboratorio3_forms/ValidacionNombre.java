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

public class ValidacionNombre extends AppCompatActivity {
    EditText inputUsuario;
    TextView resultado;
    Button mainActivity, verificar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_validacion_nombre);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        inputUsuario = findViewById(R.id.inputUsuario);
        resultado = findViewById(R.id.resultado);
        verificar = findViewById(R.id.verificar);

        //            Hacer un boton que regrese al menu
        mainActivity = findViewById(R.id.regresar);

        mainActivity.setOnClickListener(v -> {
            startActivity(new Intent(ValidacionNombre.this, MainActivity.class));
        });

        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputUsuario.getText().toString().trim();

                if (input.isEmpty()) {
                    Toast.makeText(ValidacionNombre.this, "El campo no puede estar vacío", Toast.LENGTH_SHORT).show();
                    inputUsuario.setText("");
                    resultado.setText("El campo no puede estar vacío");
                    return;
                }

                if (input.matches(".*\\d.*")) {
                    Toast.makeText(ValidacionNombre.this, "El nombre no puede contener números", Toast.LENGTH_SHORT).show();
                    inputUsuario.setText("");
                    resultado.setText("Nombre inválido: contiene números");
                    return;
                }

                resultado.setText("Bienvenido " + input);
            }
        });

    }
}