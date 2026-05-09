package com.example.apk_katalogproduk.adapter
import android.view.LayoutInflater
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
        holder.txtPrice.text = product.price.toString()
        holder.ratingPet.rating = product.rating

        holder.imgPet.setImageResource(product.imageResId)
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }
}