package com.example.icfes_up.logueo_registro;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icfes_up.databinding.ActivityRestablecerContrasena1Binding;

public class Restablecer_Contrasena_1 extends AppCompatActivity {

    private ActivityRestablecerContrasena1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityRestablecerContrasena1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        binding.btnEnviarSolicitud.setOnClickListener(v -> {
            Intent intent = new Intent(Restablecer_Contrasena_1.this, Restablecer_Contrasena_2.class);
            startActivity(intent);
        });
    }
}
