package com.example.icfes_up.logueo_registro;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icfes_up.databinding.ActivityInicioSesionBinding;

public class Inicio_Sesion extends AppCompatActivity {

    private ActivityInicioSesionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Usar ViewBinding
        binding = ActivityInicioSesionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Botón "Sobre Nosotros"
        binding.tvSobreNosotros.setOnClickListener(v -> {
            Intent intent = new Intent(Inicio_Sesion.this, Sobre_Nosotros.class);
            startActivity(intent);
        });

        // Botón "Iniciar Sesión"
        binding.btnInicoSecion.setOnClickListener(v -> {
            Intent intent = new Intent(Inicio_Sesion.this, Inicio_Sesion_Usuarios.class);
            startActivity(intent);
        });
    }
}
