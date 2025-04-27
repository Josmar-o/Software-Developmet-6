package com.example.parcial1;

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

public class MainActivity extends AppCompatActivity {

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
        EditText editText = findViewById(R.id.editText);
        Button btnMinuscula = findViewById(R.id.btnLower);
        Button btnMayuscula = findViewById(R.id.btnUpper);
        Button btnInversa = findViewById(R.id.btnInverse);
        Button btnCantidad = findViewById(R.id.btnQuantity);
        TextView txtResultado = findViewById(R.id.txtResultado);


        btnMayuscula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = editText.getText().toString().trim();

                if (texto.isEmpty()) {
                    editText.setError("Por favor, ingrese un texto");
                    return;
                }
                String textoTransformado = Transformador.mayuscula(texto);

                txtResultado.setText(textoTransformado);
                Toast.makeText(MainActivity.this, getString(R.string.toastUpper), Toast.LENGTH_SHORT).show();
            }

        });

        btnMinuscula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = editText.getText().toString().trim();

                if (texto.isEmpty()) {
                    editText.setError("Por favor, ingrese un texto");
                    return;
                }
                String textoTransformado = Transformador.minuscula(texto);

                txtResultado.setText(textoTransformado);
                Toast.makeText(MainActivity.this, getString(R.string.toastLower), Toast.LENGTH_SHORT).show();
            }

        });

        btnInversa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = editText.getText().toString().trim();

                if (texto.isEmpty()) {
                    editText.setError("Por favor, ingrese un texto");
                    return;
                }
                String textoTransformado = Transformador.inversa(texto);

                txtResultado.setText(textoTransformado);
                Toast.makeText(MainActivity.this, getString(R.string.toastInverse), Toast.LENGTH_SHORT).show();
            }

        });
        btnCantidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = editText.getText().toString().trim();

                if (texto.isEmpty()) {
                    editText.setError("Por favor, ingrese un texto");
                    return;
                }
                 int cantidadPalabras = Transformador.contarPalabras(texto);

                txtResultado.setText("Cantidad de Palabras en el texto: " + cantidadPalabras);
                Toast.makeText(MainActivity.this, getString(R.string.toastQuantity), Toast.LENGTH_SHORT).show();
            }

        });

    }
}