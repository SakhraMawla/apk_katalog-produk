package com.example.apk_katalogproduk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgPet: ImageView = itemView.findViewById(R.id.imgPet)
        val txtId: TextView = itemView.findViewById(R.id.txtId)
        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtType: TextView = itemView.findViewById(R.id.txtType)
        val txtDesc: TextView = itemView.findViewById(R.id.txtDesc)
        val txtPrice: TextView = itemView.findViewById(R.id.txtPrice)
        val ratingPet: RatingBar = itemView.findViewById(R.id.ratingPet)
        val btnAdopt: Button = itemView.findViewById(R.id.btnAdopt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)

        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val product = productList[position]

        holder.imgPet.setImageResource(product.image)
        holder.txtId.text = "ID : ${product.id}"
        holder.txtName.text = product.name
        holder.txtType.text = product.type
        holder.txtDesc.text = product.desc
        holder.txtPrice.text = product.price
        holder.ratingPet.rating = product.rating

        holder.btnAdopt.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "${product.name} ditambahkan!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}