package com.example.icfes_up.configuracion;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icfes_up.databinding.ActivityLennyEditarperfilBinding;

public class Lenny_Editarperfil extends AppCompatActivity {

    private ActivityLennyEditarperfilBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLennyEditarperfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}