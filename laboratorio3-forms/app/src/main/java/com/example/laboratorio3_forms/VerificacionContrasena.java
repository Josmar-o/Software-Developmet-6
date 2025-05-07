package com.example.laboratorio3_forms;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VerificacionContrasena extends AppCompatActivity {
    EditText inputUsuario, inputUsuario2;
    TextView resultado;
    Button verificarContra, mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verificacion_contrasena);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        inputUsuario = findViewById(R.id.inputUsuario);
        inputUsuario2 = findViewById(R.id.inputUsuario2);
        resultado = findViewById(R.id.resultado);
        verificarContra = findViewById(R.id.calcular);

        //            Hacer un boton que regrese al menu
        mainActivity = findViewById(R.id.regresar);

        mainActivity.setOnClickListener(v -> {
            startActivity(new Intent(VerificacionContrasena.this, MainActivity.class));
        });

        verificarContra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contra1 = inputUsuario.getText().toString().trim();
                String contra2 = inputUsuario2.getText().toString().trim();

                if (contra1.isEmpty() || contra2.isEmpty()) {
                    Toast.makeText(VerificacionContrasena.this, "Ambos campos deben estar llenos", Toast.LENGTH_SHORT).show();
                    resultado.setText("Faltan datos");
                    return;
                }

                if (!contra1.equals(contra2)) {
                    Toast.makeText(VerificacionContrasena.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    resultado.setText("Las contraseñas no coinciden");
                    return;
                }

                // Validaciones de seguridad
                if (contra1.length() < 8 || contra1.length() > 20) {
                    resultado.setText("La contraseña debe tener entre 8 y 20 caracteres");
                    return;
                }

                if (!contra1.matches(".*\\d.*")) {
                    resultado.setText("La contraseña debe contener al menos un número");
                    return;
                }

                if (!contra1.matches(".*[!@#$%^&*()_+=\\-\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
                    resultado.setText("La contraseña debe contener al menos un símbolo");
                    return;
                }

                resultado.setText("Contraseña válida");
                Toast.makeText(VerificacionContrasena.this, "Contraseña válida", Toast.LENGTH_SHORT).show();
            }
        });

    }
}