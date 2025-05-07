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

public class CalculadoraDescuento extends AppCompatActivity {
    EditText inputUsuario, inputUsuario2;
    TextView resultado;
    Button calcular, mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora_descuento);
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
            startActivity(new Intent(CalculadoraDescuento.this, MainActivity.class));
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputPrecio = inputUsuario.getText().toString().trim();
                String inputDescuento = inputUsuario2.getText().toString().trim();

                if (inputPrecio.isEmpty() || inputDescuento.isEmpty()) {
                    Toast.makeText(CalculadoraDescuento.this, "Ambos campos deben estar llenos", Toast.LENGTH_SHORT).show();
                    resultado.setText("Faltan datos");
                    return;
                }

                double precio, descuento;

                try {
                    precio = Double.parseDouble(inputPrecio);
                    descuento = Double.parseDouble(inputDescuento);
                } catch (NumberFormatException e) {
                    Toast.makeText(CalculadoraDescuento.this, "Ingresa solo números válidos", Toast.LENGTH_SHORT).show();
                    resultado.setText("Entrada inválida");
                    inputUsuario.setText("");
                    inputUsuario2.setText("");
                    return;
                }

                if (precio < 0 || descuento < 0) {
                    Toast.makeText(CalculadoraDescuento.this, "No se permiten valores negativos", Toast.LENGTH_SHORT).show();
                    resultado.setText("Valores inválidos");
                    inputUsuario.setText("");
                    inputUsuario2.setText("");
                    return;
                }

                double precioFinal = precio - (precio * descuento / 100);
                resultado.setText("Precio final: $" + String.format("%.2f", precioFinal));
            }
        });

    }
}