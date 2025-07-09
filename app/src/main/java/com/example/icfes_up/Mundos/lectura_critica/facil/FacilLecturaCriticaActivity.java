package com.example.icfes_up.Mundos.lectura_critica.facil;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icfes_up.R;

public class FacilLecturaCriticaActivity extends AppCompatActivity {

    private RadioGroup opcionesLectura;
    private Button btnResponder;
    private String respuestaCorrecta = "Generar una imagen visual y tranquila";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_facil_lecturacritica);

        opcionesLectura = findViewById(R.id.opcionesLectura);
        btnResponder = findViewById(R.id.btnResponderLectura);

        String[] opciones = {
                "Transmitir una escena caótica",
                "Describir el paso del tiempo con dramatismo",
                "Generar una imagen visual y tranquila",
                "Presentar una opinión del autor"
        };

        for (String texto : opciones) {
            RadioButton opcion = new RadioButton(this);
            opcion.setText(texto);
            opcion.setTextSize(15f);
            opcionesLectura.addView(opcion);
        }

        btnResponder.setOnClickListener(v -> {
            int idSeleccionado = opcionesLectura.getCheckedRadioButtonId();

            if (idSeleccionado == -1) {
                Toast.makeText(this, "Selecciona una opción", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton seleccionada = findViewById(idSeleccionado);
            String respuestaUsuario = seleccionada.getText().toString();

            if (respuestaUsuario.equals(respuestaCorrecta)) {
                Toast.makeText(this, "¡Correcto!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Incorrecto. La respuesta correcta era:\n" + respuestaCorrecta, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
