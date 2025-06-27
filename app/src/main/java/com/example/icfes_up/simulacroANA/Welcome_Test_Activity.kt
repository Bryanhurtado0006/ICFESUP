package com.example.icfes_up.simulacroANA

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.icfes_up.databinding.ActivityWelcomeTestBinding
import com.example.icfes_up.R

class Welcome_Test_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContentView(R.layout.activity_welcome_test)

        binding.btnComenzar.setOnClickListener {
            val intent = Intent(this, CategoriasActivity::class.java)
            startActivity(intent)
        }


        }
    }
