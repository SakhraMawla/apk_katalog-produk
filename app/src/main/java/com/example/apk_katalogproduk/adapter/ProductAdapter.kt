package com.example.apk_katalogproduk.adapter
import android.content.Intent
import android.view.LayoutInflater
import com.example.apk_katalogproduk.activity.DetailActivity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apk_katalogproduk.model.Product
import com.example.apk_katalogproduk.viewholder.ProductViewHolder
import com.example.apk_katalogproduk.R

class ProductAdapter (
    private val listProduct: List<Product>
)
    : RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = listProduct[position]

        holder.txtId.text = product.id.toString()
        holder.txtName.text = product.name
        holder.txtType.text = product.type
        holder.txtDesc.text = product.description
        holder.txtPrice.text = "Rp ${product.price}" // Tambahkan Rp biar lebih rapi
        holder.ratingPet.rating = product.rating
        holder.imgPet.setImageResource(product.imageResId)

        // --- TAMBAHKAN KODE DI BAWAH INI UNTUK PINDAH HALAMAN ---
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)

            // Mengirim data produk agar bisa ditampilkan di halaman detail
            intent.putExtra("PRODUCT_NAME", product.name)
            intent.putExtra("PRODUCT_TYPE", product.type)
            intent.putExtra("PRODUCT_DESC", product.description)
            intent.putExtra("PRODUCT_PRICE", product.price)
            intent.putExtra("PRODUCT_RATING", product.rating)
            intent.putExtra("PRODUCT_IMAGE", product.imageResId)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }
}