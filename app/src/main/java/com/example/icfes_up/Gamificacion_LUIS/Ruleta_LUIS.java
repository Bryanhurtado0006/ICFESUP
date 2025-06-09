package com.example.icfes_up.Gamificacion_LUIS;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.icfes_up.R;

public class Ruleta_LUIS extends AppCompatActivity {

    private Ruleta_View_Luis ruletaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ruleta_luis);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

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
        String[] opciones = null;

        // Definir preguntas y respuestas según la categoría
        switch (categoria) {
            case "Lectura Crítica":
                pregunta = "¿Cuál es el propósito principal de un texto narrativo?";
                opciones = new String[]{
                        "Contar una historia",
                        "Explicar un concepto científico",
                        "Informar sobre un evento",
                        "Describir un proceso"
                };
                break;
            case "Química":
                pregunta = "¿Qué es el pH de una solución?";
                opciones = new String[]{
                        "La concentración de protones en una solución",
                        "La cantidad de oxígeno en una solución",
                        "El nivel de acidez o alcalinidad",
                        "La concentración de iones"
                };
                break;
            case "Sociales":
                pregunta = "¿Qué factor tuvo mayor influencia en la Revolución Francesa?";
                opciones = new String[]{
                        "La lucha de clases sociales",
                        "La intervención de Napoleón",
                        "La crisis financiera del reino",
                        "La independencia de las colonias americanas"
                };
                break;
            case "Inglés":
                pregunta = "What is the past tense of 'go'?";
                opciones = new String[]{
                        "Went",
                        "Gone",
                        "Going",
                        "Goed"
                };
                break;
            case "Matemáticas":
                pregunta = "What is the area of a circle with radius 5?";
                opciones = new String[]{
                        "25π",
                        "10π",
                        "5π",
                        "15π"
                };
                break;
            case "Aleatorio":
                pregunta = "Which planet is known as the Red Planet?";
                opciones = new String[]{
                        "Mars",
                        "Venus",
                        "Jupiter",
                        "Saturn"
                };
                break;
        }

        // Crear el diálogo con las opciones de respuesta
        if (pregunta != null && opciones != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Pregunta: " + categoria)
                    .setMessage(pregunta)
                    .setPositiveButton(opciones[0], (dialog, which) -> {
                        // Acción cuando selecciona la primera opción
                    })
                    .setNegativeButton(opciones[1], (dialog, which) -> {
                        // Acción cuando selecciona la segunda opción
                    })
                    .setNeutralButton(opciones[2], (dialog, which) -> {
                        // Acción cuando selecciona la tercera opción
                    })
                    .setOnCancelListener(dialog -> {
                        // Acción cuando se cierra el diálogo
                    })
                    .show();
        }
    }
}
