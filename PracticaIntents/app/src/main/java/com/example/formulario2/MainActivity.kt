package com.example.formulario2

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar elementos del formulario
        val nameField: EditText = findViewById(R.id.name)
        val lastNameField: EditText = findViewById(R.id.last_name)
        val emailField: EditText = findViewById(R.id.email)
        val genderGroup: RadioGroup = findViewById(R.id.gender_group)
        val birthDateField: EditText = findViewById(R.id.birth_date)
        val zodiacSpinner: Spinner = findViewById(R.id.zodiac_spinner)
        val workSwitch: Switch = findViewById(R.id.work_switch)
        val sportSwitch: Switch = findViewById(R.id.sport_switch)
        val formDateField: EditText = findViewById(R.id.form_date)
        val formTimeField: EditText = findViewById(R.id.form_time)
        val saveButton: Button = findViewById(R.id.save_button)

        // Configuración del Spinner para signos zodiacales
        val zodiacSigns = arrayOf(
            "Aries", "Tauro", "Géminis", "Cáncer", "Leo", "Virgo",
            "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, zodiacSigns)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        zodiacSpinner.adapter = adapter

        // Configuración del DatePicker para "Fecha de Nacimiento"
        birthDateField.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    birthDateField.setText("$selectedDay/${selectedMonth + 1}/$selectedYear")
                },
                year,
                month,
                day
            )
            datePicker.show()
        }

        // Configuración del DatePicker para "Fecha de Llenado"
        formDateField.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    formDateField.setText("$selectedDay/${selectedMonth + 1}/$selectedYear")
                },
                year,
                month,
                day
            )
            datePicker.show()
        }

        // Acción del botón "Guardar Datos"
        saveButton.setOnClickListener {
            // Obtener datos del formulario
            val name = nameField.text.toString()
            val lastName = lastNameField.text.toString()
            val email = emailField.text.toString()
            val gender = when (genderGroup.checkedRadioButtonId) {
                R.id.gender_male -> "Masculino"
                R.id.gender_female -> "Femenino"
                else -> "Otro"
            }
            val birthDate = birthDateField.text.toString()
            val zodiacSign = zodiacSpinner.selectedItem.toString()
            val workStatus = if (workSwitch.isChecked) "Sí" else "No"
            val sportStatus = if (sportSwitch.isChecked) "Sí" else "No"
            val formDate = formDateField.text.toString()
            val formTime = formTimeField.text.toString()

            // Validación de campos obligatorios
            if (name.isEmpty() || lastName.isEmpty() || email.isEmpty() || birthDate.isEmpty() || formDate.isEmpty() || formTime.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos obligatorios.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Crear intent y enviar los datos
            val intent = Intent(this, DisplayDataActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("lastName", lastName)
            intent.putExtra("email", email)
            intent.putExtra("gender", gender)
            intent.putExtra("birthDate", birthDate)
            intent.putExtra("zodiacSign", zodiacSign)
            intent.putExtra("workStatus", workStatus)
            intent.putExtra("sportStatus", sportStatus)
            intent.putExtra("formDate", formDate)
            intent.putExtra("formTime", formTime)
            startActivity(intent)
        }
    }
}
