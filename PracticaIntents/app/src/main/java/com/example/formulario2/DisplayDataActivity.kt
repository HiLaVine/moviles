package com.example.formulario2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_data)

        // Referencias a los elementos del diseño
        val displayData: TextView = findViewById(R.id.display_data)
        val backButton: Button = findViewById(R.id.back_button)
        val nextButton: Button = findViewById(R.id.next_button)

        // Obtener los datos enviados desde MainActivity
        val name = intent.getStringExtra("name") ?: "N/A"
        val lastName = intent.getStringExtra("lastName") ?: "N/A"
        val email = intent.getStringExtra("email") ?: "N/A"
        val gender = intent.getStringExtra("gender") ?: "N/A"
        val birthDate = intent.getStringExtra("birthDate") ?: "N/A"
        val zodiacSign = intent.getStringExtra("zodiacSign") ?: "N/A"
        val workStatus = intent.getStringExtra("workStatus") ?: "N/A"
        val sportStatus = intent.getStringExtra("sportStatus") ?: "N/A"
        val formDate = intent.getStringExtra("formDate") ?: "N/A"
        val formTime = intent.getStringExtra("formTime") ?: "N/A"

        // Mostrar los datos en el TextView
        displayData.text = """
            Nombre: $name
            Apellido: $lastName
            Correo: $email
            Género: $gender
            Fecha de nacimiento: $birthDate
            Signo zodiacal: $zodiacSign
            ¿Trabajas?: $workStatus
            ¿Practicas deporte?: $sportStatus
            Fecha de llenado: $formDate
            Hora de llenado: $formTime
        """.trimIndent()

        // Acción del botón "Regresar"
        backButton.setOnClickListener {
            finish() // Cierra la actividad actual y regresa a MainActivity
        }

        // Acción del botón "Siguiente"
        nextButton.setOnClickListener {
            val intent = Intent(this, ActionActivity::class.java)
            startActivity(intent) // Ir a la actividad ActionActivity
        }
    }
}
