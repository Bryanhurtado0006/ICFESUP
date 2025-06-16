package com.example.icfes_up.logueo_registro;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icfes_up.R;
import com.example.icfes_up.databinding.ActivityRestablecerContrasena2Binding;

public class Restablecer_Contrasena_3 extends AppCompatActivity {

    private ActivityRestablecerContrasena2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restablecer_contrasena3);

        binding = ActivityRestablecerContrasena2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnContinuar.setOnClickListener(v -> {
            Intent intent = new Intent(Restablecer_Contrasena_3.this, Inicio_Sesion_Usuarios.class);
            startActivity(intent);
        });
    }
}
