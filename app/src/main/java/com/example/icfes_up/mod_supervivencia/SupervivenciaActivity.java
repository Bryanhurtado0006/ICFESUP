package com.example.icfes_up.mod_supervivencia;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.RadioButton;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.icfes_up.databinding.ActividadSupervivenciaBinding;

import java.util.List;

public class SupervivenciaActivity extends AppCompatActivity {

    private ActividadSupervivenciaBinding binding;
    private List<Pregunta> preguntas;
    private int indiceActual = 0;
    private int respuestasCorrectas = 0;
    private CountDownTimer timer;
    private boolean examenReiniciadoPorSalida = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActividadSupervivenciaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cargarPreguntasSimuladas();
        mostrarPregunta();
        iniciarTemporizadorPorPregunta(90_000); // 1 minuto 30 segundos

        binding.btnSiguiente.setOnClickListener(view -> {
            verificarRespuesta();
            indiceActual++;

            if (indiceActual < preguntas.size()) {
                mostrarPregunta();
                iniciarTemporizadorPorPregunta(90_000);
            } else {
                finalizarExamen();
            }
        });
    }

    private void cargarPreguntasSimuladas() {
        preguntas = List.of(
                new Pregunta(
                        "Una empresa decide reducir el número de empleados en un 20%. Si originalmente tenía 250 empleados, ¿cuántos empleados tendrá después de la reducción?",
                        List.of("200", "225", "240", "230"),
                        "200"
                ),
                new Pregunta(
                        "Lea el siguiente fragmento:\n\n\"El sol se ocultaba lentamente detrás de las montañas, mientras las sombras se alargaban sobre el valle silencioso.\"\n\n¿Cuál es el efecto principal del uso de este lenguaje?",
                        List.of(
                                "Transmitir una escena caótica",
                                "Describir el paso del tiempo con dramatismo",
                                "Generar una imagen visual y tranquila",
                                "Presentar una opinión del autor"
                        ),
                        "Generar una imagen visual y tranquila"
                ),
                new Pregunta(
                        "¿Cuál de las siguientes es una función principal del ADN en los organismos vivos?",
                        List.of(
                                "Producir energía celular",
                                "Regular la temperatura corporal",
                                "Almacenar y transmitir información genética",
                                "Proteger a las células de virus"
                        ),
                        "Almacenar y transmitir información genética"
                )
        );
    }

    private void mostrarPregunta() {
        if (preguntas == null || preguntas.isEmpty()) return;

        binding.grupoOpciones.clearCheck();

        Pregunta pregunta = preguntas.get(indiceActual);
        binding.textoPregunta.setText(pregunta.getEnunciado());

        binding.opcion1.setText(pregunta.getOpciones().get(0));
        binding.opcion2.setText(pregunta.getOpciones().get(1));
        binding.opcion3.setText(pregunta.getOpciones().get(2));
        binding.opcion4.setText(pregunta.getOpciones().get(3));
    }

    private void verificarRespuesta() {
        int idSeleccionado = binding.grupoOpciones.getCheckedRadioButtonId();
        if (idSeleccionado == -1) return;

        RadioButton seleccionada = findViewById(idSeleccionado);
        String respuestaCorrecta = preguntas.get(indiceActual).getRespuestaCorrecta();

        if (seleccionada.getText().toString().equals(respuestaCorrecta)) {
            respuestasCorrectas++;
        }
    }

    private void iniciarTemporizadorPorPregunta(long duracionMillis) {
        if (timer != null) timer.cancel();

        timer = new CountDownTimer(duracionMillis, 1000) {
            public void onTick(long millisUntilFinished) {
                long segundos = millisUntilFinished / 1000;
                long minutos = segundos / 60;
                segundos %= 60;
                binding.cronometro.setText(String.format("Tiempo restante: %02d:%02d", minutos, segundos));
            }

            public void onFinish() {
                indiceActual++;
                if (indiceActual < preguntas.size()) {
                    mostrarPregunta();
                    iniciarTemporizadorPorPregunta(90_000);
                } else {
                    finalizarExamen();
                }
            }
        }.start();
    }

    private void finalizarExamen() {
        if (timer != null) timer.cancel();

        int total = preguntas.size();
        int puntaje = (respuestasCorrectas * 100) / total;

        String mensajeFinal = "Respuestas correctas: " + respuestasCorrectas + " de " + total +
                "\nPuntaje estimado: " + puntaje + "%\n¡Buen trabajo!";

        new AlertDialog.Builder(this)
                .setTitle("Resultado final")
                .setMessage(mensajeFinal)
                .setPositiveButton("Reintentar", (dialog, which) -> {
                    indiceActual = 0;
                    respuestasCorrectas = 0;
                    mostrarPregunta();
                    iniciarTemporizadorPorPregunta(90_000);
                })
                .setNegativeButton("Volver al inicio", (dialog, which) -> finish())
                .setCancelable(false)
                .show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        examenReiniciadoPorSalida = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (examenReiniciadoPorSalida) {
            examenReiniciadoPorSalida = false;

            new AlertDialog.Builder(this)
                    .setTitle("Examen reiniciado")
                    .setMessage("Saliste de la app. El test se reinició por seguridad.")
                    .setPositiveButton("Aceptar", null)
                    .show();

            indiceActual = 0;
            respuestasCorrectas = 0;
            mostrarPregunta();
            iniciarTemporizadorPorPregunta(90_000);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) timer.cancel();
        binding = null;
    }
}



