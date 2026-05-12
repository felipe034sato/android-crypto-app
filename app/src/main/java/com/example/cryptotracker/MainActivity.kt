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
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonUpdate = findViewById<Button>(R.id.btn_update)

        buttonUpdate.setOnClickListener {
            loadBitcoinInfo()
        }
    }

    private fun loadBitcoinInfo() {

        CoroutineScope(Dispatchers.Main).launch {

            try {

                val service = ApiFactory().createService()
                val response = service.getBitcoinData()

                if (response.isSuccessful) {

                    val result = response.body()

                    val txtValue = findViewById<TextView>(R.id.txt_value)
                    val txtDate = findViewById<TextView>(R.id.txt_date)

                    val currentValue = result?.ticker?.last?.toDoubleOrNull()

                    if (currentValue != null) {

                        val format =
                            NumberFormat.getCurrencyInstance(Locale("pt", "BR"))

                        txtValue.text = format.format(currentValue)
                    }

                    val date =
                        result?.ticker?.date?.let { Date(it * 1000L) }

                    val formatter =
                        SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())

                    txtDate.text = formatter.format(date!!)

                } else {

                    Toast.makeText(
                        this@MainActivity,
                        "Erro ao buscar dados",
                        Toast.LENGTH_LONG
                    ).show()
                }

            } catch (e: Exception) {

                Toast.makeText(
                    this@MainActivity,
                    "Falha: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}