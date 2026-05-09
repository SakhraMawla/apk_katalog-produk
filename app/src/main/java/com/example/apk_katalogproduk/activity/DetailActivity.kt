package com.example.apk_katalogproduk.activity

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apk_katalogproduk.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Hubungkan ID sesuai XML kamu
        val imgDetail: ImageView = findViewById(R.id.detailImage)
        val tvName: TextView = findViewById(R.id.detailName)
        val tvType: TextView = findViewById(R.id.detailType)
        val tvDesc: TextView = findViewById(R.id.detailDesc)
        val tvPrice: TextView = findViewById(R.id.detailPrice)
        val btnCheckout: Button = findViewById(R.id.btnCheckout)

        // Ambil data dari intent
        val name = intent.getStringExtra("PRODUCT_NAME")
        val type = intent.getStringExtra("PRODUCT_TYPE")
        val desc = intent.getStringExtra("PRODUCT_DESC")
        val price = intent.getDoubleExtra("PRODUCT_PRICE", 0.0)
        val image = intent.getIntExtra("PRODUCT_IMAGE", 0)

        // Tampilkan ke layar
        tvName.text = name
        tvType.text = type
        tvDesc.text = desc
        tvPrice.text = "Rp $price"
        imgDetail.setImageResource(image)

        btnCheckout.setOnClickListener {
            Toast.makeText(this, "Berhasil memproses $name!", Toast.LENGTH_SHORT).show()
        }
    }
}