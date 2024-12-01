package com.example.toolbarnavigationscroll

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_icon5 -> {
                    // Acción para Icono 5
                    true
                }
                R.id.nav_icon6 -> {
                    // Acción para Icono 6
                    true
                }
                R.id.nav_icon7 -> {
                    // Acción para Icono 7
                    true
                }
                R.id.nav_icon8 -> {
                    // Acción para Icono 8
                    true
                }
                else -> false
            }
        }
    }
}