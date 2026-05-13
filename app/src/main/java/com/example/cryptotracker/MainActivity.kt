package com.example.cryptotracker

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptotracker.service.ApiFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnUpdate = findViewById<Button>(R.id.btn_update)
        val txtValue = findViewById<TextView>(R.id.txt_value)
        val txtDate = findViewById<TextView>(R.id.txt_date)

        btnUpdate.setOnClickListener {

            txtValue.text = "Carregando..."
            txtDate.text = "Carregando..."

            CoroutineScope(Dispatchers.Main).launch {

                try {

                    val service = ApiFactory().createService()
                    val response = service.getBitcoinData()

                    if (response.isSuccessful) {

                        val result = response.body()
                        val ticker = result?.ticker

                        if (ticker != null) {

                            val lastValue = ticker.last?.toDoubleOrNull()

                            txtValue.text = lastValue?.let {
                                "R$ %.2f".format(it)
                            } ?: "Valor inválido"

                            val date = Date(ticker.date * 1000L)

                            val formatter = SimpleDateFormat(
                                "dd/MM/yyyy HH:mm:ss",
                                Locale.getDefault()
                            )

                            txtDate.text = formatter.format(date)

                        } else {

                            txtValue.text = "Sem dados"
                            txtDate.text = ""

                            Toast.makeText(
                                this@MainActivity,
                                "Resposta vazia da API",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    } else {

                        txtValue.text = "Erro API"
                        txtDate.text = ""

                        Toast.makeText(
                            this@MainActivity,
                            "HTTP: ${response.code()}",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                } catch (e: Exception) {

                    e.printStackTrace()

                    txtValue.text = "EXCEPTION: ${e.javaClass.simpleName}"
                    txtDate.text = ""

                    Toast.makeText(
                        this@MainActivity,
                        e.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}