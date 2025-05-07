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

public class MultiplicadorDeNumeros extends AppCompatActivity {
    EditText inputUsuario, inputUsuario2;
    TextView resultado;
    Button calcular, mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_multiplicador_de_numeros);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        inputUsuario = findViewById(R.id.inputUsuario);
        inputUsuario2 = findViewById(R.id.inputUsuario2);
        resultado = findViewById(R.id.resultado);
        calcular = findViewById(R.id.calcular);

        //            Hacer un boton que regrese al menu
        mainActivity = findViewById(R.id.regresar);

        mainActivity.setOnClickListener(v -> {
            startActivity(new Intent(MultiplicadorDeNumeros.this, MainActivity.class));
        });

        //Programa
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = inputUsuario.getText().toString().trim();
                String input2 = inputUsuario2.getText().toString().trim();

                if (input1.isEmpty() || input2.isEmpty()) {
                    Toast.makeText(MultiplicadorDeNumeros.this, "Ambos campos deben estar llenos", Toast.LENGTH_SHORT).show();
                    resultado.setText("Faltan datos");
                    return;
                }

                double numero1, numero2;

                try {
                    numero1 = Double.parseDouble(input1);
                    numero2 = Double.parseDouble(input2);
                } catch (NumberFormatException e) {
                    Toast.makeText(MultiplicadorDeNumeros.this, "Ingresa solo números válidos", Toast.LENGTH_SHORT).show();
                    resultado.setText("Entrada inválida");
                    inputUsuario.setText("");
                    inputUsuario2.setText("");
                    return;
                }

                double mult = numero1 * numero2;
                resultado.setText("Resultado: " + String.format("%.2f", mult));
            }
        });


    }
}