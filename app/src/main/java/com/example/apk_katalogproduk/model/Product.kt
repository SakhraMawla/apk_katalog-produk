package com.example.apk_katalogproduk.model

class Product {
    data class Pet(
        val id: Int,
        val name: String,
        val type: String,
        val price: Double,
        val rating: Float,
        val imageResId: Int,
        val description: String
    )
}