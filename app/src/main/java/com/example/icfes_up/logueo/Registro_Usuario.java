package com.example.icfes_up.logueo;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.icfes_up.databinding.ActivityRegistroUsuarioBinding;
import com.example.icfes_up.model.DbHelper;

public class Registro_Usuario extends AppCompatActivity {

    private ActivityRegistroUsuarioBinding binding;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityRegistroUsuarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbHelper = DbHelper.getInstance(this);

        binding.btnRegistrarUsuario.setOnClickListener(v -> {
            String nombre = binding.inputNombre.getText().toString().trim();
            String apellido = binding.inputApellido.getText().toString().trim();
            String tipoDocumento = binding.inputTipoDocumento.getText().toString().trim();
            String numeroDocumento = binding.inputNumeroDocumento.getText().toString().trim();
            String email = binding.inputEmail.getText().toString().trim();
            String password = binding.inputPassword.getText().toString().trim();
            String institucion = binding.inputInstitucion.getText().toString().trim();
            String adminDocumento = binding.inputAdminDocumento.getText().toString().trim();

            if (nombre.isEmpty() || apellido.isEmpty() || tipoDocumento.isEmpty() || numeroDocumento.isEmpty()
                    || email.isEmpty() || password.isEmpty() || institucion.isEmpty() || adminDocumento.isEmpty()) {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                return;
            }

            // Obtener idAdministrador por el número de documento del administrador
            int idAdministrador = -1;
            Cursor cursor = dbHelper.getReadableDatabase().rawQuery(
                    "SELECT idAdministrador FROM administradores WHERE numeroIdentidadAdministrador = ?",
                    new String[]{adminDocumento}
            );

            if (cursor.moveToFirst()) {
                idAdministrador = cursor.getInt(0);
            }
            cursor.close();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("apellido", apellido);
            values.put("tipoDeDocumento", tipoDocumento);
            values.put("numeroIdentidadUsuario", numeroDocumento);
            values.put("email", email);
            values.put("password", DbHelper.hashPassword(password)); // Hasheo
            values.put("institucion", institucion);
            values.put("numeroIdentidadAdministrador", adminDocumento);

            if (idAdministrador != -1) {
                values.put("idAdministrador", idAdministrador);
            } else {
                values.putNull("idAdministrador");
            }

            long id = dbHelper.insertarUsuario(values);

            if (id > 0) {
                Toast.makeText(this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Error al registrar. Verifica si ya existe.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
