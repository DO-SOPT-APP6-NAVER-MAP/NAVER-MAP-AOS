package org.sopt.navermap.data.model.remote.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseGetDetailDto(
    @SerialName("data")
    val data: Data,
    @SerialName("message")
    val message: String,
    @SerialName("statusCode")
    val status: Int
){
    @Serializable
    data class Data(
        @SerialName("blogReview")
        val blogReview: Int,
        @SerialName("category")
        val category: String,
        @SerialName("characters")
        val characters: String,
        @SerialName("closeTime")
        val closeTime: String,
        @SerialName("description")
        val description: String,
        @SerialName("detail")
        val detail: String,
        @SerialName("detailAddress")
        val detailAddress: String,
        @SerialName("direction")
        val direction: String,
        @SerialName("name")
        val name: String,
        @SerialName("number")
        val number: String,
        @SerialName("sns")
        val sns: String,
        @SerialName("stars")
        val stars: String,
        @SerialName("visitorReview")
        val visitorReview: Int
    )
}