package com.example.icfes_up.Mundos;

public class Mundo {
    private String nombre;
    private int imagen;

    public Mundo(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }
}

