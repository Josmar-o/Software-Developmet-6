package com.example.laboratorio1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    EditText txtNum1, txtNum2;
    Button btnSuma, btnDividir, btnRestar, btnMultiplicar;
    TextView txtResultado;
    public boolean siTextoVacio(){
        if(txtNum1.getText().toString().trim().equals("") || txtNum2.getText().toString().trim().equals("")){
            Toast.makeText(this, "Ambos campos deben tener texto", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }


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


        //CODIGO

        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        btnSuma = findViewById(R.id.btnSuma);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultplicar);
        btnDividir = findViewById(R.id.btnDividir);
        txtResultado = findViewById((R.id.txtResultado));

//        spinner = findViewById(R.id.spinnerOptions);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
//                this,
//                R.array.array_operaciones,
//                android.R.layout.simple_spinner_item
//        );
//        // Specify the layout to use when the list of choices appears.
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Apply the adapter to the spinner.
//        spinner.setAdapter(adapter);

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(siTextoVacio()){
                    return;
                    }

                int num1 = Integer.parseInt(txtNum1.getText().toString());
                int num2 = Integer.parseInt(txtNum2.getText().toString());

                int result;

                result = Calculadora.suma(num1, num2);
                txtResultado.setText(String.valueOf(result));

            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(siTextoVacio()){
                    return;
                }
                int num1 = Integer.parseInt(txtNum1.getText().toString());
                int num2 = Integer.parseInt(txtNum2.getText().toString());
                int result;

                result = Calculadora.resta(num1, num2);
                txtResultado.setText(String.valueOf(result));

            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if (siTextoVacio()){
                    return;
                }
                int num1 = Integer.parseInt(txtNum1.getText().toString());
                int num2 = Integer.parseInt(txtNum2.getText().toString());

                int result;
                result = Calculadora.multiplicacion(num1, num2);
                txtResultado.setText(String.valueOf(result));

            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (siTextoVacio()){
                    return;
                }

                int num1 = Integer.parseInt(txtNum1.getText().toString());
                int num2 = Integer.parseInt(txtNum2.getText().toString());

                if (num2 == 0) {
                    Toast.makeText(MainActivity.this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
                    txtResultado.setText("ERROR");
                } else{

                    int result;

                    result = Calculadora.division(num1, num2);
                    txtResultado.setText(String.valueOf(result));
                }
            }
        });






    }

}