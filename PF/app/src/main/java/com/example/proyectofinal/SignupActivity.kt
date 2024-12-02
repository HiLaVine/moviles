
    package com.example.proyectofinal

    import android.content.Intent
    import android.os.Bundle
    import android.widget.Button
    import android.widget.EditText
    import android.widget.TextView
    import android.widget.Toast
    import androidx.appcompat.app.AppCompatActivity

    class SignupActivity : AppCompatActivity() {

        private lateinit var nameEditText: EditText
        private lateinit var aliasEditText: EditText
        private lateinit var emailEditText: EditText
        private lateinit var passwordEditText: EditText
        private lateinit var signupButton: Button
        private lateinit var loginTextView: TextView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_signup)

            // Inicializar los componentes
            nameEditText = findViewById(R.id.nameEditText)
            aliasEditText = findViewById(R.id.aliasEditText)
            emailEditText = findViewById(R.id.emailEditText)
            passwordEditText = findViewById(R.id.passwordEditText)
            signupButton = findViewById(R.id.signupButton)
            loginTextView = findViewById(R.id.loginTextView)

            // Acciones para los botones y enlaces
            signupButton.setOnClickListener {
                // Validar los campos de entrada
                val name = nameEditText.text.toString().trim()
                val alias = aliasEditText.text.toString().trim()
                val email = emailEditText.text.toString().trim()
                val password = passwordEditText.text.toString().trim()

                if (name.isEmpty() || alias.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    // Mostrar mensaje de error si algún campo está vacío
                    Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                } else {
                    // Aquí podrías guardar la información en una base de datos o hacer una llamada a la API
                    // Por ahora, solo mostramos un mensaje de éxito
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

                    // Después de un registro exitoso, redirigir al login
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()  // Finaliza la actividad actual para que no regrese
                }
            }

            // Acción para ir a la pantalla de Login si el usuario ya tiene cuenta
            loginTextView.setOnClickListener {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()  // Finaliza la actividad actual para que no regrese
            }
        }
    }


