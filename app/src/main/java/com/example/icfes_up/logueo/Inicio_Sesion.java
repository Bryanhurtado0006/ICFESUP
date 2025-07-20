package com.example.icfes_up.logueo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icfes_up.MainActivity;
import com.example.icfes_up.databinding.ActivityInicioSesionBinding;
import com.example.icfes_up.model.DbHelper;

public class Inicio_Sesion extends AppCompatActivity {

    private ActivityInicioSesionBinding binding;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityInicioSesionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbHelper = new DbHelper(this);

        binding.tvSobreNosotros.setOnClickListener(v -> {
            Intent intent = new Intent(Inicio_Sesion.this, Sobre_Nosotros.class);
            startActivity(intent);
        });

        binding.tvOlvidasteContrasena.setOnClickListener(v -> {
            Intent intent = new Intent(Inicio_Sesion.this, Restablecer_Contrasena.class);
            startActivity(intent);
        });

        binding.btnIniciarSesion.setOnClickListener(v -> {
            String correo = binding.inputCorreo.getText().toString().trim();
            String contrasena = binding.inputContrasena.getText().toString().trim();

            if (correo.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
            } else {
                if (dbHelper.validarUsuario(correo, contrasena)) {
                    Toast.makeText(this, "Inicio de sesión como Usuario", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                } else if (dbHelper.validarAdministrador(correo, contrasena)) {
                    Toast.makeText(this, "Inicio de sesión como Administrador", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
