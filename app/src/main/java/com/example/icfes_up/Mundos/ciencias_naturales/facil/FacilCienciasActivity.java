package com.example.icfes_up.Mundos.ciencias_naturales.facil;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icfes_up.R;

public class FacilCienciasActivity extends AppCompatActivity {

    private TextView pregunta;
    private RadioGroup opcionesGroup;
    private RadioButton opcion1, opcion2, opcion3, opcion4;
    private android.widget.Button btnResponder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_facil_ciencias);

        pregunta = findViewById(R.id.tituloFacil); // o cambia el ID si usas otro TextView para pregunta
        btnResponder = findViewById(R.id.btnSiguienteCiencias);

        // Asignamos una pregunta de ejemplo
        pregunta.setText("¿Cuál es la función principal del sistema respiratorio?");

        // Creamos dinámicamente las opciones usando RadioGroup (puedes usar XML también)
        opcionesGroup = new RadioGroup(this);
        opcionesGroup.setOrientation(RadioGroup.VERTICAL);

        opcion1 = new RadioButton(this);
        opcion1.setText("Transportar nutrientes");

        opcion2 = new RadioButton(this);
        opcion2.setText("Bombear sangre");

        opcion3 = new RadioButton(this);
        opcion3.setText("Intercambiar gases");

        opcion4 = new RadioButton(this);
        opcion4.setText("Proteger órganos");

        opcionesGroup.addView(opcion1);
        opcionesGroup.addView(opcion2);
        opcionesGroup.addView(opcion3);
        opcionesGroup.addView(opcion4);

        // Insertamos el RadioGroup en el layout
        ((android.widget.LinearLayout) findViewById(R.id.layoutFacilCiencias)).addView(opcionesGroup, 1);

        btnResponder.setOnClickListener(v -> {
            int seleccion = opcionesGroup.getCheckedRadioButtonId();

            if (seleccion == -1) {
                Toast.makeText(this, "Selecciona una respuesta", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton seleccionada = findViewById(seleccion);
            String respuesta = seleccionada.getText().toString();

            if (respuesta.equals("Intercambiar gases")) {
                Toast.makeText(this, "¡Correcto!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Incorrecto. La respuesta correcta es 'Intercambiar gases'.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

