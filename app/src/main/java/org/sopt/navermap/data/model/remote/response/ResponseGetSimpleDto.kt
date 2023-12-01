package org.sopt.navermap.data.model.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.sopt.navermap.data.model.local.SearchResult

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
        @SerialName("rodeNameAddress")
        val rodeNameAddress: String,
        @SerialName("localAddress")
        val localAddress: String,
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

        fun getPreviewImg() = previewImgs.map { data ->
            SearchResult.Image(
                previewId = data.previewId,
                previewImgUrl = data.previewImgUrl
            )
        }
    }

    fun getSimpleData() = SearchResult(
        name = this.data.name,
        category = this.data.category,
        description = this.data.description,
        distance = this.data.distance,
        address = this.data.address,
        closeTime = this.data.closeTime,
        stars = this.data.stars,
        visitorReview = this.data.visitorReview,
        blogReview = this.data.blogReview,
        previewImgs = this.data.getPreviewImg()
    )

}