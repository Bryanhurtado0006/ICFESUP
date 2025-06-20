package com.example.icfes_up.logueo;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.icfes_up.databinding.ActivityRestablecerContrasena2Binding;

public class Restablecer_Contrasena_2 extends AppCompatActivity {

    private ActivityRestablecerContrasena2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityRestablecerContrasena2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnContinuar.setOnClickListener(v -> {
            Intent intent = new Intent(Restablecer_Contrasena_2.this, Restablecer_Contrasena_3.class);
            startActivity(intent);
        });
    }
}
