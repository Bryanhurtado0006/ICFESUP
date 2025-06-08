package com.example.icfes_up.logueo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.icfes_up.MainActivity;
import com.example.icfes_up.R;
import com.example.icfes_up.model.DbHelper; // Asegúrate de que la ruta del paquete sea correcta


public class Inicio_Sesion_Usuarios extends AppCompatActivity {

    private EditText etCorreo, etContrasena;
    private Button btnIniciar;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio_sesion_usuarios);

        // Adaptar padding al sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Referencias UI
        etCorreo = findViewById(R.id.et_correo_Daniel);
        etContrasena = findViewById(R.id.et_contraseña_Daniel);
        btnIniciar = findViewById(R.id.btnIrInicio);

        // DBHelper
        dbHelper = new DbHelper(this);

        // Botón iniciar sesión
        btnIniciar.setOnClickListener(v -> {
            String correo = etCorreo.getText().toString().trim();
            String contrasena = etContrasena.getText().toString().trim();

            if (correo.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean existe = dbHelper.validarUsuario(correo, contrasena);

            if (existe) {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                // Cuando crees la actividad, descomenta estas líneas:
                Intent intent = new Intent(this, MainActivity.class);
                 startActivity(intent);
                finish();

            } else {
                Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
