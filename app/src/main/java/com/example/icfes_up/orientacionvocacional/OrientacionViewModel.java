package com.example.icfes_up.orientacionvocacional;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class OrientacionViewModel extends ViewModel {

    private int seccionActual = 0;
    private final List<String> respuestas = new ArrayList<>();

    // Datos de las secciones y preguntas (simplificado)
    private final String[] titulos = {
            "Intereses personales",
            "Habilidades",
            "Estilo de aprendizaje",
            "Valores personales",
            "Preferencias laborales"
    };

    private final String[] preguntas = {
            "¿Qué actividad disfrutas más?",
            "¿En qué eres naturalmente bueno?",
            "¿Cómo aprendes mejor?",
            "¿Qué valoras más en la vida?",
            "¿Qué ambiente laboral prefieres?"
    };

    private final String[][] opciones = {
            {
                    "Leer sobre temas nuevos",
                    "Resolver acertijos o problemas matemáticos",
                    "Ayudar a otras personas",
                    "Crear cosas (dibujar, escribir, diseñar)",
                    "Armar o reparar objetos"
            },
            {
                    "Comunicar ideas",
                    "Resolver problemas",
                    "Empatía y escuchar",
                    "Expresarte artísticamente",
                    "Trabajar con herramientas o máquinas"
            },
            {
                    "Leyendo",
                    "Resolviendo ejercicios",
                    "Escuchando a otros",
                    "Haciendo cosas prácticas",
                    "Observando ejemplos"
            },
            {
                    "El conocimiento",
                    "La lógica y el orden",
                    "El bienestar de otros",
                    "La creatividad",
                    "La eficiencia y el trabajo práctico"
            },
            {
                    "Ambiente académico",
                    "Ambiente estructurado",
                    "Ambiente social",
                    "Ambiente artístico",
                    "Ambiente técnico o de campo"
            }
    };

    public String getTituloActual() {
        return titulos[seccionActual];
    }

    public String getPreguntaActual() {
        return preguntas[seccionActual];
    }

    public String[] getOpcionesActuales() {
        return opciones[seccionActual];
    }

    public void guardarRespuesta(String respuesta) {
        respuestas.add(respuesta);
        seccionActual++;
    }

    public boolean testCompletado() {
        return seccionActual >= titulos.length;
    }

    public List<String> getRespuestas() {
        return respuestas;
    }
}