package com.example.icfes_up.Gamificacion_LUIS;


import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icfes_up.Gamificacion_LUIS.Raking_Luis;
import com.example.icfes_up.databinding.ActivityLuisRetosBinding;

public class Luis_Retos extends AppCompatActivity {

    private ActivityLuisRetosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityLuisRetosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.TXTRaking.setOnClickListener(View ->
        {
            Intent intent=new Intent(Luis_Retos.this, Raking_Luis.class);
            startActivity(intent);
        });










    }
}