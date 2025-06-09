package com.example.icfes_up.Gamificacion_LUIS;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.icfes_up.R;

public class Ruleta_LUIS extends AppCompatActivity {

    private Ruleta_View_Luis ruletaView;
    private TextView preguntaTextView;
    private Button respuesta1, respuesta2, respuesta3;

    // Lista de preguntas y respuestas por materia
    private String[] preguntas = {
            "¿Qué es la lectura crítica?",
            "¿Cuál es la fórmula química para el agua?",
            "¿Qué año comenzó la Primera Guerra Mundial?",
            "¿Qué significa 'Hello' en español?",
            "¿Cuál es la raíz cuadrada de 81?",
            "¿Cuál es el continente donde se encuentra Egipto?"
    };

    private String[][] respuestas = {
            {"Análisis de textos", "Leer rápido", "Escuchar"},
            {"H2O", "CO2", "O2"},
            {"1914", "1918", "1939"},
            {"Hola", "Adiós", "Gracias"},
            {"9", "8", "10"},
            {"Asia", "Europa", "África"}
    };

    private int[] respuestasCorrectas = {0, 0, 0, 0, 0, 0}; // Índices de respuestas correctas para cada pregunta

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

        // Inicialización de las vistas
        ruletaView = findViewById(R.id.ruletaView);
        Button btnGirar = findViewById(R.id.btnGirar);
        preguntaTextView = findViewById(R.id.pregunta);
        respuesta1 = findViewById(R.id.respuesta1);
        respuesta2 = findViewById(R.id.respuesta2);
        respuesta3 = findViewById(R.id.respuesta3);

        btnGirar.setOnClickListener(v -> {
            ruletaView.girarRuleta(() -> {
                String categoria = ruletaView.getCategoriaSeleccionada();
                Toast.makeText(this, "¡Categoría seleccionada: " + categoria + "!", Toast.LENGTH_LONG).show();

                // Obtener el índice de la categoría seleccionada
                int categoriaIndex = getCategoriaIndex(categoria);

                // Mostrar la pregunta y respuestas correspondientes
                if (categoriaIndex != -1) {
                    mostrarPregunta(categoriaIndex);
                } else {
                    Toast.makeText(this, "Categoría no encontrada.", Toast.LENGTH_SHORT).show();
                }
            });
        });

        // Configuración de botones de respuestas
        respuesta1.setOnClickListener(v -> verificarRespuesta(0));
        respuesta2.setOnClickListener(v -> verificarRespuesta(1));
        respuesta3.setOnClickListener(v -> verificarRespuesta(2));
    }

    private void mostrarPregunta(int categoriaIndex) {
        // Mostrar la pregunta y las respuestas
        preguntaTextView.setText(preguntas[categoriaIndex]);
        respuesta1.setText(respuestas[categoriaIndex][0]);
        respuesta2.setText(respuestas[categoriaIndex][1]);
        respuesta3.setText(respuestas[categoriaIndex][2]);

        // Hacer visibles los elementos
        preguntaTextView.setVisibility(View.VISIBLE);
        respuesta1.setVisibility(View.VISIBLE);
        respuesta2.setVisibility(View.VISIBLE);
        respuesta3.setVisibility(View.VISIBLE);
    }

    private void verificarRespuesta(int respuestaSeleccionada) {
        // Verificar si la respuesta seleccionada es correcta
        int categoriaIndex = getCategoriaIndex(ruletaView.getCategoriaSeleccionada());
        if (categoriaIndex != -1 && respuestaSeleccionada == respuestasCorrectas[categoriaIndex]) {
            Toast.makeText(this, "¡Respuesta correcta!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Respuesta incorrecta. Intenta de nuevo.", Toast.LENGTH_SHORT).show();
        }

        // Ocultar las preguntas y respuestas después de responder
        preguntaTextView.setVisibility(View.GONE);
        respuesta1.setVisibility(View.GONE);
        respuesta2.setVisibility(View.GONE);
        respuesta3.setVisibility(View.GONE);
    }

    private int getCategoriaIndex(String categoria) {
        // Mapear la categoría seleccionada al índice
        switch (categoria) {
            case "Lectura Crítica":
                return 0;
            case "Química":
                return 1;
            case "Sociales":
                return 2;
            case "Inglés":
                return 3;
            case "Matemáticas":
                return 4;
            case "Aleatorio":
                return 5;
            default:
                return -1;  // Retorna -1 si la categoría no es válida
        }
    }
}
