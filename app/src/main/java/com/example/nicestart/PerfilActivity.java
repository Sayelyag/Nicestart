package com.example.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile); // <-- tu XML del perfil

        // Flecha de volver
        findViewById(R.id.back_arrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vuelve al MainActivity
                Intent intent = new Intent(PerfilActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // opcional, para cerrar el perfil
            }
        });
    }
}