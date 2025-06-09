package com.example.icfes_up.Gamificacion_LUIS;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icfes_up.R;

public class Ruleta_LUIS extends AppCompatActivity {

    private Ruleta_View_Luis ruletaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruleta_luis);

        ruletaView = findViewById(R.id.ruletaView);
        Button btnGirar = findViewById(R.id.btnGirar);

        btnGirar.setOnClickListener(v -> {
            ruletaView.girarRuleta(() -> {
                String categoria = ruletaView.getCategoriaSeleccionada();
                Toast.makeText(this, "¡Categoría seleccionada: " + categoria + "!", Toast.LENGTH_LONG).show();
                mostrarPregunta(categoria); // Llamamos a la función para mostrar la pregunta
            });
        });
    }

    // Mostrar una pregunta dependiendo de la categoría seleccionada
    private void mostrarPregunta(String categoria) {
        String pregunta = "";
        final String[] opciones = new String[4];
        final String[] respuestaCorrecta = new String[1];

        // Definir preguntas y respuestas según la categoría
        switch (categoria) {
            case "Lectura Crítica":
                pregunta = "¿Cuál es el propósito principal de un texto narrativo?";
                opciones[0] = "Contar una historia";
                opciones[1] = "Explicar un concepto científico";
                opciones[2] = "Informar sobre un evento";
                opciones[3] = "Describir un proceso";
                respuestaCorrecta[0] = "Contar una historia"; // Respuesta correcta
                break;
            case "Química":
                pregunta = "¿Qué es el pH de una solución?";
                opciones[0] = "La concentración de protones en una solución";
                opciones[1] = "La cantidad de oxígeno en una solución";
                opciones[2] = "El nivel de acidez o alcalinidad";
                opciones[3] = "La concentración de iones";
                respuestaCorrecta[0] = "El nivel de acidez o alcalinidad"; // Respuesta correcta
                break;
            case "Sociales":
                pregunta = "¿Qué factor tuvo mayor influencia en la Revolución Francesa?";
                opciones[0] = "La lucha de clases sociales";
                opciones[1] = "La intervención de Napoleón";
                opciones[2] = "La crisis financiera del reino";
                opciones[3] = "La independencia de las colonias americanas";
                respuestaCorrecta[0] = "La crisis financiera del reino"; // Respuesta correcta
                break;
            case "Inglés":
                pregunta = "What is the past tense of 'go'?";
                opciones[0] = "Went";
                opciones[1] = "Gone";
                opciones[2] = "Going";
                opciones[3] = "Goed";
                respuestaCorrecta[0] = "Went"; // Respuesta correcta
                break;
            case "Matemáticas":
                pregunta = "¿Cuál es el área de un círculo con radio 5?";
                opciones[0] = "25π";
                opciones[1] = "10π";
                opciones[2] = "5π";
                opciones[3] = "15π";
                respuestaCorrecta[0] = "25π"; // Respuesta correcta
                break;
            case "Aleatorio":
                pregunta = "¿Cuál es el planeta conocido como el planeta rojo?";
                opciones[0] = "Marte";
                opciones[1] = "Venus";
                opciones[2] = "Júpiter";
                opciones[3] = "Saturno";
                respuestaCorrecta[0] = "Marte"; // Respuesta correcta
                break;
        }

        // Crear un AlertDialog para mostrar las opciones como botones
        if (pregunta != null && opciones != null && respuestaCorrecta != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Pregunta: " + categoria)
                    .setMessage(pregunta)
                    .setCancelable(false);

            // Crear un conjunto de botones con las opciones de respuesta
            builder.setPositiveButton(opciones[0], (dialog, which) -> verificarRespuesta(opciones[0], respuestaCorrecta[0]));
            builder.setNegativeButton(opciones[1], (dialog, which) -> verificarRespuesta(opciones[1], respuestaCorrecta[0]));
            builder.setNeutralButton(opciones[2], (dialog, which) -> verificarRespuesta(opciones[2], respuestaCorrecta[0]));
            builder.setOnCancelListener(dialog -> verificarRespuesta(opciones[3], respuestaCorrecta[0])); // Acción por defecto

            builder.show();
        }
    }

    // Método para verificar si la respuesta es correcta o incorrecta
    private void verificarRespuesta(String respuestaSeleccionada, String respuestaCorrecta) {
        if (respuestaSeleccionada.equals(respuestaCorrecta)) {
            // Si la respuesta es correcta
            Toast.makeText(this, "¡Correcto!", Toast.LENGTH_SHORT).show();
        } else {
            // Si la respuesta es incorrecta
            Toast.makeText(this, "Respuesta incorrecta. Intenta de nuevo.", Toast.LENGTH_SHORT).show();
        }
    }
}
