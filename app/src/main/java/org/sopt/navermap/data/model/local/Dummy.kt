package org.sopt.navermap.data.model.local

data class Dummy(
    val email: String,
    val id: String,
    val name: String,
)


data class LocationRaw(
    val placeId: Int,
    val name: String,
    val detailAddress: String,
    val distance: String,
    val category: String,
    val visitorReview: Int
)

data class Location(
    val placeId: Int,
    val nameEntered: String,
    val nameRemain: String,
    val detailAddress: String,
    val distance: String,
    val category: String,
    val visitorReview: Int
)