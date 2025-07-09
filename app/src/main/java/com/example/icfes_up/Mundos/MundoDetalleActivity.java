package com.example.icfes_up.Mundos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.icfes_up.Mundos.ciencias_naturales.facil.FacilCienciasActivity;
import com.example.icfes_up.Mundos.ingles.facil.FacilInglesActivity;
import com.example.icfes_up.Mundos.lectura_critica.facil.FacilLecturaCriticaActivity;
import com.example.icfes_up.Mundos.matematicas.facil.FacilMatematicasActivity;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icfes_up.Mundos.sociales.facil.FacilSocialesActivity;
import com.example.icfes_up.R;

public class MundoDetalleActivity extends AppCompatActivity {

    private TextView tituloMundo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_mundo_detalle);

        tituloMundo = findViewById(R.id.tituloMundo);
        Button btnFacil = findViewById(R.id.btnFacil);


        String nombreMundo = getIntent().getStringExtra("nombre_mundo");
        if (nombreMundo != null) {
            tituloMundo.setText("Bienvenido a " + nombreMundo);
        } else {
            Toast.makeText(this, "Mundo no recibido", Toast.LENGTH_SHORT).show();
            finish();
        }

        // Aquí puedes agregar botones para acceder a niveles: Fácil, Medio, Difícil, etc.

        //nivel facil matematicas
        btnFacil.setOnClickListener(v -> {
            String nombre = nombreMundo.trim().toLowerCase(); // Normaliza
            switch (nombre) {
                case "campo de batalla matematico":
                    startActivity(new Intent(this, FacilMatematicasActivity.class));
                    break;
                case "laboratorio galactico":
                    startActivity(new Intent(this, FacilCienciasActivity.class));
                    break;
                case "english arena":
                    startActivity(new Intent(this, FacilInglesActivity.class));
                    break;
                case "biblioteca encantada":
                    startActivity(new Intent(this, FacilLecturaCriticaActivity.class));
                    break;
                case "republica de las decisiones":
                    startActivity(new Intent(this, FacilSocialesActivity.class));
                    break;
                default:
                    Toast.makeText(this, "Mundo no reconocido", Toast.LENGTH_SHORT).show();
            }
        });


    }
}

