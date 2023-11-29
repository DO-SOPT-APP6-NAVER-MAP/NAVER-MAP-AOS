package org.sopt.navermap.data.model.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseGetSimpleDto (
    @SerialName("statusCode")
    val statusCode: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: Data
){
    @Serializable
    data class Data(
        @SerialName("name")
        val name: String,
        @SerialName("category")
        val category: String,
        @SerialName("description")
        val description: String,
        @SerialName("distance")
        val distance: String,
        @SerialName("address")
        val address: String,
        @SerialName("closeTime")
        val closeTime: String,
        @SerialName("stars")
        val stars: String,
        @SerialName("visitorReview")
        val visitorReview: Int,
        @SerialName("blogReview")
        val blogReview: Int,
        @SerialName("previewImgs")
        val previewImgs: List<Image>
    ) {
        @Serializable
        data class Image(
            @SerialName("previewId")
            val previewId: Int,
            @SerialName("previewImgUrl")
            val previewImgUrl: String
        )
    }
}