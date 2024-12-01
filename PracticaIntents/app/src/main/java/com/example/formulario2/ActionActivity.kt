package com.example.formulario2

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class ActionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action)

        // Botón para realizar una llamada
        val callButton: Button = findViewById(R.id.call_button)

        callButton.setOnClickListener {
            val phoneNumber = "tel:123456789" // Reemplaza este número con el que quieras llamar
            val callIntent = Intent(Intent.ACTION_CALL, Uri.parse(phoneNumber))

            // Verificar si se tiene el permiso para realizar llamadas
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(callIntent)
            } else {
                // Solicitar permiso para realizar llamadas
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 1)
            }
        }

        // Botón para abrir la cámara
        val openCameraButton: Button = findViewById(R.id.open_camera_button)

        openCameraButton.setOnClickListener {
            // Verificar si ya tenemos permisos para usar la cámara
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, 2) // 2 es el código de solicitud
            } else {
                // Solicitar permiso en tiempo de ejecución
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 100)
            }
        }

        // Botón para abrir el navegador
        val openBrowserButton: Button = findViewById(R.id.open_browser_button)

        openBrowserButton.setOnClickListener {
            val url = "https://www.google.com"
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(browserIntent)
        }

        // Botón para mostrar los contactos
        val showContactsButton: Button = findViewById(R.id.show_contacts_button)

        showContactsButton.setOnClickListener {
            val contactsIntent = Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"))
            startActivity(contactsIntent)
        }

        // Botón para establecer una alarma
        val setAlarmButton: Button = findViewById(R.id.set_alarm_button)

        setAlarmButton.setOnClickListener {
            try {
                val alarmIntent = Intent(AlarmClock.ACTION_SET_ALARM)

                // Puedes configurar la hora y minuto deseados para la alarma
                alarmIntent.putExtra(AlarmClock.EXTRA_HOUR, 8) // 8 AM
                alarmIntent.putExtra(AlarmClock.EXTRA_MINUTES, 30) // 30 minutos

                // Verificar si el dispositivo tiene una actividad para manejar la alarma
                if (alarmIntent.resolveActivity(packageManager) != null) {
                    startActivity(alarmIntent)
                } else {
                    Toast.makeText(this, "No se puede establecer la alarma", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Error al intentar establecer la alarma", Toast.LENGTH_SHORT).show()
            }
        }

        // Botón para regresar a DisplayDataActivity
        val backButton: Button = findViewById(R.id.back_button)

        backButton.setOnClickListener {
            finish() // Esto regresa a la actividad anterior
        }
    }

    // Manejo de la respuesta del permiso para la llamada telefónica
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido, realizar la llamada
                val phoneNumber = "tel:123456789"
                val callIntent = Intent(Intent.ACTION_CALL, Uri.parse(phoneNumber))
                startActivity(callIntent)
            } else {
                // Permiso denegado
                Toast.makeText(this, "Permiso de llamada denegado", Toast.LENGTH_SHORT).show()
            }
        }

        // Manejo de la respuesta del permiso para la cámara
        if (requestCode == 100) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido, abrir la cámara
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, 2)
            } else {
                // Permiso denegado
                Toast.makeText(this, "Permiso de cámara denegado", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Manejar el resultado de la cámara (si se desea obtener una foto o video)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 2 && resultCode == RESULT_OK) {
            // Aquí puedes manejar la foto capturada
            val imageBitmap = data?.extras?.get("data") as? Bitmap
            // Usa el Bitmap como quieras, por ejemplo mostrarlo en una ImageView
        }
    }
}
