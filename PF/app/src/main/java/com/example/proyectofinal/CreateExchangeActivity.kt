package com.example.proyectofinal

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreateExchangeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_exchange) // Aquí se pondrá el layout de la nueva actividad

        // Habilitar diseño Edge-to-Edge
        enableEdgeToEdge()

        // Opcionalmente, puedes configurar los márgenes del sistema (como la barra de estado y navegación)
        ViewCompat.getWindowInsetsController(window.decorView)?.let { controller ->
            controller.isAppearanceLightStatusBars = true // Ejemplo: barra de estado de color claro
            controller.isAppearanceLightNavigationBars = true // Ejemplo: barras de navegación claras
        }
    }
}
