package com.example.saudeja_22300872

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val estoqueMedicamentos = mapOf(
        "Paracetamol" to true,
        "Ibuprofeno" to true,
        "Amoxicilina" to true,
        "Dipirona" to true,
        "Azitromicina" to false,
        "Aspirina" to false
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputMedicamento = findViewById<EditText>(R.id.inputMedicamento)
        val btnConsultar = findViewById<Button>(R.id.btnConsultar)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnConsultar.setOnClickListener {
            val nomeMedicamento = inputMedicamento.text.toString().trim()
            val disponibilidade = estoqueMedicamentos[nomeMedicamento]

            if (disponibilidade == true) {
                txtResultado.text = "✅ $nomeMedicamento está disponível em estoque. Pode vir buscar!"
            } else if (disponibilidade == false) {
                txtResultado.text = "❌ $nomeMedicamento está indisponível no momento."
            } else {
                txtResultado.text = "⚠️ Medicamento não encontrado no sistema."
            }
        }
    }
}