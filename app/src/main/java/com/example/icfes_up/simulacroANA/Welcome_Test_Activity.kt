package com.example.icfes_up.simulacroANA

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.icfes_up.databinding.ActivityWelcomeTestBinding

class Welcome_Test_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnComenzar.setOnClickListener {
            val intent = Intent(this, CategoriasActivity::class.java)
            intent.putExtra("destino","categorias")
            startActivity(intent)
        }
    }
}

