package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.widget.ImageView

class CreateExchangeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_exchange) // Aquí se pondrá el layout de la nueva actividad

        // Opcionalmente, puedes configurar los márgenes del sistema (como la barra de estado y navegación)
        ViewCompat.getWindowInsetsController(window.decorView)?.let { controller ->
            controller.isAppearanceLightStatusBars = true // Barra de estado con texto oscuro
            controller.isAppearanceLightNavigationBars = true // Barra de navegación con iconos claros
        }

        // Obtener referencia a ImageView (la que se va a presionar)
        val imageView3: ImageView = findViewById(R.id.imageView3)

        // Configurar el OnClickListener para el ImageView
        imageView3.setOnClickListener {
            // Intent para navegar a la nueva actividad
            val intent = Intent(this, Editarr::class.java)
            startActivity(intent)
        }
    }
}
