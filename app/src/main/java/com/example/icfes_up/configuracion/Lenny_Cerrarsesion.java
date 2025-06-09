package com.example.icfes_up.configuracion;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icfes_up.databinding.ActivityLennyCerrarsesionBinding;

public class Lenny_Cerrarsesion extends AppCompatActivity {

    private ActivityLennyCerrarsesionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = ActivityLennyCerrarsesionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}