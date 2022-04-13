package ru.churkin.sbdelivery

import java.util.*

data class Product(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val image: String = "",
    val oldPrice: String = "",
    val price: Int = 0,
    val rating: Float = 0f,
    val likes: Int = 0,
    val category: String = "",
    val commentsCount: Int = 0,
    val active: Boolean = true,
    val createdAt: Long = 0,
    val updatedAt: Long = 0
)
