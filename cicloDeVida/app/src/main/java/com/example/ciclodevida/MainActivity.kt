package com.example.ciclodevida

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log

class MainActivity : AppCompatActivity() {
    private val logEtiqueta = "MainActivity"
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val text1: TextView = findViewById(R.id.txt_1)
        text1.setText("Adios a todos")
        Toast.makeText(this, "En el onCreate", Toast.LENGTH_SHORT).show()
        Log.e(logEtiqueta, "En el evento onCreate")
    }

   override fun onStart() {
        super.onStart()
        Toast.makeText(this, "En el onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "En el onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "En el onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "En el onStop", Toast.LENGTH_SHORT).show()
        Log.e(logEtiqueta, "En el evento onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(logEtiqueta, "En el evento onDestroy - La actividad ha sido destruida")
        Toast.makeText(this, "En el onDestroy", Toast.LENGTH_SHORT).show()
    }
}

