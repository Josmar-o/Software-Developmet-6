package com.example.laboratorio5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    EditText txtUrl;

    Button btnCargarUrl, btnCargarRecurso;
    ImageView imagen;

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
        txtUrl = findViewById(R.id.txtUrl);
        btnCargarUrl = findViewById(R.id.btnCargarUrl);
        btnCargarRecurso = findViewById(R.id.btnCargarRecurso);
        imagen = findViewById(R.id.imagen);

        btnCargarUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(MainActivity.this)
                        .load(txtUrl.getText().toString())
                        .placeholder(R.drawable.loading)
                        .error(R.drawable.delete)
                        .into(imagen);
            }
        });



        btnCargarRecurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreImagen = txtUrl.getText().toString().trim();
                int resId = getResources().getIdentifier(nombreImagen, "drawable", getPackageName());

                Glide.with(MainActivity.this)
                        .load(resId)
                        .placeholder(R.drawable.loading)
                        .error(R.drawable.delete)
                        .into(imagen);
            }
        });
    }
}