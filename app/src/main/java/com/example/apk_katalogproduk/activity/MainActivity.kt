package com.example.apk_katalogproduk.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apk_katalogproduk.R
import com.example.apk_katalogproduk.adapter.ProductAdapter
import com.example.apk_katalogproduk.model.Product
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        // Set tampilan 2 kolom menyamping
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        val btnTambah: FloatingActionButton = findViewById(R.id.fabCart)
        val listProduct = mutableListOf(
            // --- KELOMPOK KUCING ---
            Product(1, "Milo", "Kucing Persia", 450000.0, 4.5f, R.drawable.kucing_persia, "Kucing lucu dan aktif"),
            Product(2, "Oyen", "Kucing Anggora", 450000.0, 4.0f, R.drawable.kucing_anggora, "Kucing penurut dan suka bermain"),
            Product(3, "Luna", "Kucing Siam", 550000.0, 4.7f, R.drawable.kucing_siam, "Kucing anggun dengan corak warna unik"),
            Product(4, "Kiko", "Kucing Scottish Fold", 900000.0, 4.8f, R.drawable.kucing_scottish_fold, "Kucing dengan telinga lipat yang unik"),
            Product(5, "Bella", "Kucing Maine Coon", 1500000.0, 5.0f, R.drawable.kucing_maine_coon, "Kucing ras terbesar yang sangat lembut"),

            // --- KELOMPOK ANJING ---
            Product(6, "Bobi", "Anjing Husky", 750000.0, 5.0f, R.drawable.anjing_husky, "Anjing gagah dan sangat setia"),
            Product(7, "Rex", "Anjing Golden", 850000.0, 4.9f, R.drawable.anjing_golden, "Anjing sangat ramah dan setia"),
            Product(8, "Bruno", "Anjing Bulldog", 1200000.0, 4.5f, R.drawable.anjing_bulldog, "Anjing yang tenang dan sangat tangguh"),
            Product(9, "Molly", "Anjing Poodle", 650000.0, 4.6f, R.drawable.anjing_poodle, "Anjing pintar dengan bulu yang cantik"),
            Product(10, "Zorro", "Anjing Beagle", 700000.0, 4.4f, R.drawable.anjing_beagle, "Anjing pelacak yang lincah dan berani")
        )

        adapter = ProductAdapter(listProduct)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter

        btnTambah.setOnClickListener {

            val newProduct = Product(
                listProduct.size + 1,
                "Produk Baru",
                "Kucing Baru",
                300000.0,
                4.0f,
                R.drawable.ic_launcher_foreground,
                "Produk tambahan otomatis"
            )

            listProduct.add(newProduct)
            adapter.notifyItemInserted(listProduct.size - 1)
            recyclerView.smoothScrollToPosition(listProduct.size - 1)

            Toast.makeText(
                this,
                "Hewan berhasil ditambahkan",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}