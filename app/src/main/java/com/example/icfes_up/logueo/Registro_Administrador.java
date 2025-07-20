package com.example.icfes_up.logueo;

import android.content.ContentValues;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.icfes_up.databinding.ActivityRegistroAdministradorBinding;
import com.example.icfes_up.model.DbHelper;

public class Registro_Administrador extends AppCompatActivity {

    private ActivityRegistroAdministradorBinding binding;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityRegistroAdministradorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbHelper = DbHelper.getInstance(this);

        binding.btnRegistrar.setOnClickListener(view -> {
            String nombre = binding.inputNombre.getText().toString().trim();
            String apellido = binding.inputApellido.getText().toString().trim();
            String tipoDocumento = binding.inputTipoDocumento.getText().toString().trim();
            String numeroIdentidad = binding.inputNumeroIdentidad.getText().toString().trim();
            String email = binding.inputEmail.getText().toString().trim();
            String password = binding.inputPassword.getText().toString().trim();
            String direccion = binding.inputDireccion.getText().toString().trim();
            String institucion = binding.inputInstitucion.getText().toString().trim();

            if (nombre.isEmpty() || apellido.isEmpty() || tipoDocumento.isEmpty() || numeroIdentidad.isEmpty()
                    || email.isEmpty() || password.isEmpty() || institucion.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos obligatorios", Toast.LENGTH_SHORT).show();
                return;
            }

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("apellido", apellido);
            values.put("tipoDeDocumento", tipoDocumento);
            values.put("numeroIdentidadAdministrador", numeroIdentidad);
            values.put("email", email);
            values.put("password", DbHelper.hashPassword(password)); // Hasheo aquí
            values.put("direccion", direccion);
            values.put("institucion", institucion);

            long id = dbHelper.insertarAdministrador(values);

            if (id > 0) {
                Toast.makeText(this, "Administrador registrado correctamente", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Error al registrar: el correo o número ya existe", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
