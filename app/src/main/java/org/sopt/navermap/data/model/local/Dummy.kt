package org.sopt.navermap.data.model.local

data class Dummy(
    val email: String,
    val id: String,
    val name: String,
)


data class LocationRaw(
    val id: Int,
    val name: String,
    val address: String,
    val distance: String,
    val category: String,
    val review: Int
)

data class Location(
    val id: Int,
    val nameEntered: String,
    val nameRemain: String,
    val address: String,
    val distance: String,
    val category: String,
    val review: Int
)