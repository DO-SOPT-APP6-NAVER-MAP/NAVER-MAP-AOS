package org.sopt.navermap.data.model.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.sopt.navermap.data.model.local.LocationRaw

@Serializable
data class ResponseSearchNameDto(
    @SerialName("statusCode")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<ResponseData>,
) {
    @Serializable
    data class ResponseData(
        @SerialName("placeId")
        val placeId: Int,
        @SerialName("name")
        val name: String,
        @SerialName("category")
        val category: String,
        @SerialName("detailAddress")
        val detailAddress: String,
        @SerialName("distance")
        val distance: String,
        @SerialName("visitorReview")
        val visitorReview: Int
    ) {
        fun toLocationRaw() = LocationRaw(
            placeId = placeId,
            name = name,
            detailAddress = detailAddress,
            distance = distance,
            category = category,
            visitorReview = visitorReview
        )
    }
}
