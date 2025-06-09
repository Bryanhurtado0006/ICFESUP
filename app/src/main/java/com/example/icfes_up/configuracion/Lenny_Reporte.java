package com.example.icfes_up.configuracion;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icfes_up.databinding.ActivityLennyReporteBinding;

public class Lenny_Reporte extends AppCompatActivity {

    private ActivityLennyReporteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLennyReporteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}