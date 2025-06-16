package com.example.icfes_up.configuracion;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icfes_up.databinding.ActivityLennyVerperfilBinding;

public class Lenny_Verperfil extends AppCompatActivity {
    private ActivityLennyVerperfilBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLennyVerperfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}