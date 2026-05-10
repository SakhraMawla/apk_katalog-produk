package com.example.apk_katalogproduk.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.apk_katalogproduk.R
import com.example.apk_katalogproduk.model.Product


class DetailProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val btnAdopt: Button=findViewById(R.id.btnCheckout)

        val name = intent.getStringExtra("PRODUCT_NAME")
        val type = intent.getStringExtra("PRODUCT_TYPE")
        val price = intent.getDoubleExtra("PRODUCT_PRICE", 0.0)
        val description = intent.getStringExtra("PRODUCT_DESC")
        val image = intent.getIntExtra("PRODUCT_IMAGE", 0)

        val imgProduct = findViewById<ImageView>(R.id.detailImage)
        val txtName = findViewById<TextView>(R.id.detailName)
        val txtType = findViewById<TextView>(R.id.detailType)
        val txtPrice = findViewById<TextView>(R.id.detailPrice)
        val txtDesc = findViewById<TextView>(R.id.detailDesc)

        imgProduct.setImageResource(image)
        txtName.text = name
        txtPrice.text = "Rp $price"
        txtDesc.text = description
        txtType.text = type

        btnAdopt.setOnClickListener {

            val intent = Intent(
                this,
                CheckoutActivity::class.java
            )
            intent.putExtra("PRODUCT_PRICE", price)
            startActivity(intent)
        }
    }
}