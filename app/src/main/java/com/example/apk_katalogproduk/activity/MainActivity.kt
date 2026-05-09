package com.example.apk_katalogproduk.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apk_katalogproduk.R
import com.example.apk_katalogproduk.adapter.ProductAdapter
import com.example.apk_katalogproduk.model.Product

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val listProduct: List<Product> = listOf(

            Product(
                1,
                "Milo",
                "Kucing Persia",
                450000.00,
                4.5f,
                R.drawable.ic_launcher_foreground,
                "Kucing lucu dan aktif"
            ),

            Product(
                2,
                "Oyen",
                "Kucing Anggora",
                450000.00,
                4.0f,
                R.drawable.ic_launcher_foreground,
                "Kucing lucu dan aktif"
            ),

            Product(
                3,
                "Bobi",
                "Anjing Husky",
                450000.00,
                5.0f,
                R.drawable.ic_launcher_foreground,
                "Anjing lucu dan aktif"
            )
        )

        adapter = ProductAdapter(listProduct)
        recyclerView.adapter = adapter
    }
}

