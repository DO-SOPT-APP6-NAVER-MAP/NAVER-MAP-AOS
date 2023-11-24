package org.sopt.navermap.data.model.local

data class Location(
    val id: Int,
    val name: String,
    val address: String,
    val distance: String,
    val category: String,
    val review: Int,
    val type: Int
)