package com.example.icfes_up.mod_supervivencia;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.icfes_up.databinding.ActividadBienvenidaSupervivenciaBinding;

public class BienvenidaSupervivenciaActivity extends AppCompatActivity {

    private ActividadBienvenidaSupervivenciaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActividadBienvenidaSupervivenciaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnIniciarExamen.setOnClickListener(v -> {
            startActivity(new Intent(this, SupervivenciaActivity.class));
        });
    }
}

