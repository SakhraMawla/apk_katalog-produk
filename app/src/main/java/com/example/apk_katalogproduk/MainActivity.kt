package com.example.apk_katalogproduk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var productList: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        productList = ArrayList()

        productList.add(
            Product(
                1,
                "Milo",
                "Kucing Persia",
                "Rp 450.000",
                4.5f,
                R.drawable.ic_launcher_background,
                "Kucing lucu dan aktif"
            )
        )

        productList.add(
            Product(
                2,
                "Buddy",
                "Anjing Golden",
                "Rp 850.000",
                5.0f,
                R.drawable.ic_launcher_background,
                "Anjing ramah dan pintar"
            )
        )

        productAdapter = ProductAdapter(productList)

        recyclerView.layoutManager = GridLayoutManager(this, 2)

        recyclerView.adapter = productAdapter
    }
}