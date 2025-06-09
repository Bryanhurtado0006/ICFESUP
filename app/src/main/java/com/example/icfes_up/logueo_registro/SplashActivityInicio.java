package com.example.icfes_up.logueo_registro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.icfes_up.R;

public class SplashActivityInicio extends AppCompatActivity {

    private static final int SPLASH_DURATION = 2000; // duración del splash en milisegundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_inicio);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Iniciar MainActivity después de un retardo
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivityInicio.this, Inicio_Sesion.class);
            startActivity(intent);
            finish();
        }, SPLASH_DURATION);
    }
}
