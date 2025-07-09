package com.example.icfes_up.Mundos.ingles.facil;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icfes_up.R;

public class FacilInglesActivity extends AppCompatActivity {

    private TextView tituloFacil;
    private RadioGroup opcionesGroup;
    private Button btnResponder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_facil_ingles);

        tituloFacil = findViewById(R.id.tituloFacil);
        btnResponder = findViewById(R.id.btnSiguienteIngles);

        // Crear el grupo de opciones dinámicamente
        opcionesGroup = new RadioGroup(this);
        opcionesGroup.setOrientation(RadioGroup.VERTICAL);

        String[] opciones = {"Dog", "Car", "Tree", "Table"};
        String correcta = "Dog";

        for (String opcion : opciones) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(opcion);
            radioButton.setTextSize(16f);
            opcionesGroup.addView(radioButton);
        }

        ((LinearLayout) findViewById(R.id.layoutFacilIngles)).addView(opcionesGroup, 1); // Añade después del título

        btnResponder.setOnClickListener(v -> {
            int seleccion = opcionesGroup.getCheckedRadioButtonId();

            if (seleccion == -1) {
                Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton opcionSeleccionada = findViewById(seleccion);
            String respuesta = opcionSeleccionada.getText().toString();

            if (respuesta.equals(correcta)) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Wrong! The correct answer was " + correcta, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

