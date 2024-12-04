package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Configura el botón para abrir la nueva actividad
        val buttonCreados: Button = findViewById(R.id.button1)

        buttonCreados.setOnClickListener {
            val intent = Intent(this, CreateExchangeActivity::class.java)
            startActivity(intent)
        }
        // Configura el botón 2 para abrir otra actividad
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(this, Participate::class.java) // Reemplaza con la nueva actividad
            startActivity(intent)
        }

        // Configura el botón 2 para abrir otra actividad
        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            val intent = Intent(this, Codigoo::class.java) // Reemplaza con la nueva actividad
            startActivity(intent)
        }

        // Asegura los márgenes para el diseño Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
