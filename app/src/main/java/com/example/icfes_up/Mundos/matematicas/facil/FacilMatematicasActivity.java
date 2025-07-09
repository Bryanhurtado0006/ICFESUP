package com.example.icfes_up.Mundos.matematicas.facil;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icfes_up.R;

public class FacilMatematicasActivity extends AppCompatActivity {

    private RadioGroup opcionesGroup;
    private Button btnResponder;
    private String respuestaCorrecta = "12";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_facil_matematicas);

        opcionesGroup = findViewById(R.id.opcionesGroup);
        btnResponder = findViewById(R.id.btnResponder);

        String[] opciones = {
                "7", "12", "16", "8"
        };

        for (String texto : opciones) {
            RadioButton opcion = new RadioButton(this);
            opcion.setText(texto);
            opcion.setTextSize(15f);
            opcionesGroup.addView(opcion);
        }

        btnResponder.setOnClickListener(v -> {
            int seleccion = opcionesGroup.getCheckedRadioButtonId();

            if (seleccion == -1) {
                Toast.makeText(this, "Selecciona una respuesta", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton seleccionada = findViewById(seleccion);
            String respuesta = seleccionada.getText().toString();

            if (respuesta.equals(respuestaCorrecta)) {
                Toast.makeText(this, "¡Correcto!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Incorrecto. La respuesta era " + respuestaCorrecta, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

