package com.example.icfes_up.logueo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.icfes_up.databinding.ActivityRestablecerContrasenaBinding;
import com.example.icfes_up.model.DbHelper;

public class Restablecer_Contrasena extends AppCompatActivity {

    private ActivityRestablecerContrasenaBinding binding;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityRestablecerContrasenaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbHelper = new DbHelper(this);

        binding.btnRestablecer.setOnClickListener(v -> {
            String email = binding.inputCorreo.getText().toString().trim();
            String nuevaContrasena = binding.inputNuevaContrasena.getText().toString().trim();
            String confirmarContrasena = binding.inputConfirmarContrasena.getText().toString().trim();

            if (email.isEmpty() || nuevaContrasena.isEmpty() || confirmarContrasena.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!nuevaContrasena.equals(confirmarContrasena)) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean actualizado = dbHelper.restablecerContrasenaUsuario(email, nuevaContrasena);

            if (actualizado) {
                Toast.makeText(this, "Contraseña actualizada con éxito", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Error: correo no encontrado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
