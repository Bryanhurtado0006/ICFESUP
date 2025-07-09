package com.example.icfes_up.Mundos.sociales.facil;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icfes_up.R;

public class FacilSocialesActivity extends AppCompatActivity {

    private RadioGroup opcionesSociales;
    private Button btnResponder;
    private String respuestaCorrecta = "Romper la dependencia política de España";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_facil_sociales);

        opcionesSociales = findViewById(R.id.opcionesSociales);
        btnResponder = findViewById(R.id.btnResponderSociales);

        String[] opciones = {
                "Promover el comercio con Europa",
                "Romper la dependencia política de España",
                "Expandir el cristianismo",
                "Establecer una monarquía en América"
        };

        for (String texto : opciones) {
            RadioButton opcion = new RadioButton(this);
            opcion.setText(texto);
            opcion.setTextSize(15f);
            opcionesSociales.addView(opcion);
        }

        btnResponder.setOnClickListener(v -> {
            int idSeleccionado = opcionesSociales.getCheckedRadioButtonId();

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
