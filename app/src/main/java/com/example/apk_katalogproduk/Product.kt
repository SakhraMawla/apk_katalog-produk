package com.example.apk_katalogproduk

data class Product(
    val id: Int,
    val name: String,
    val type: String,
    val price: String,
    val rating: Float,
    val image: Int,
    val desc: String
)