package com.example.icfes_up.logueo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.icfes_up.databinding.ActivityMenuLogueoBinding;

public class Menu_Logueo extends AppCompatActivity {

    private ActivityMenuLogueoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuLogueoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegistroAdministrador.setOnClickListener(v -> {
            startActivity(new Intent(this, Registro_Administrador.class));
        });

        binding.btnRegistroUsuario.setOnClickListener(v -> {
            startActivity(new Intent(this, Registro_Usuario.class));
        });

        binding.btnInicioSesion.setOnClickListener(v -> {
            startActivity(new Intent(this, Inicio_Sesion.class));
        });
    }
}
