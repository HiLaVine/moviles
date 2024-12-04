package com.example.proyectofinal

import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Participate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_particiations_exchange)

        // Obtener la referencia a la ImageView
        val imageView: ImageView = findViewById(R.id.imageView5)

        // Crear un ObjectAnimator para mover la imagen hacia abajo en el eje Y
        val animator = ObjectAnimator.ofFloat(imageView, "translationY", -500f, 0f)
        animator.duration = 1000 // Duración de la animación en milisegundos
        animator.start() // Iniciar la animación
    }
}
