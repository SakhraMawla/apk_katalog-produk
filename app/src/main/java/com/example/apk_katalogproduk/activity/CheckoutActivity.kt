package com.example.apk_katalogproduk.activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apk_katalogproduk.R

class CheckoutActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkout)
        val btnConfirm: Button = findViewById(R.id.btnConfirm)
        val price = intent.getDoubleExtra("PRODUCT_PRICE", 0.0)
        val txtPrice = findViewById<TextView>(R.id.txtTotal)

        txtPrice.text="Rp $price"
        btnConfirm.setOnClickListener {
            Toast.makeText(
                this,
                "Hewan berhasil di adopsi",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
