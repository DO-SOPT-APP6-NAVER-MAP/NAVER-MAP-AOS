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
    val statusCode: Int
){
    @Serializable
    data class Data(
        @SerialName("blogReview")
        val blogReview: Int,
        @SerialName("blogReviewInfos")
        val blogReviewInfos: List<BlogReviewInfo>,
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
        @SerialName("menuInfos")
        val menuInfos: List<MenuInfo>,
        @SerialName("name")
        val name: String,
        @SerialName("number")
        val number: String,
        @SerialName("sns")
        val sns: String,
        @SerialName("stars")
        val stars: String,
        @SerialName("visitorReview")
        val visitorReview: Int,
        @SerialName("visitorReviewInfos")
        val visitorReviewInfos: List<VisitorReviewInfo>
    ){
        @Serializable
        data class BlogReviewInfo(
            @SerialName("visitorReviewAuthor")
            val visitorReviewAuthor: String,
            @SerialName("visitorReviewAuthorThumbnail")
            val visitorReviewAuthorThumbnail: String,
            @SerialName("visitorReviewContent")
            val visitorReviewContent: String,
            @SerialName("visitorReviewId")
            val visitorReviewId: Int,
            @SerialName("visitorReviewImgUrl")
            val visitorReviewImgUrl: String,
            @SerialName("visitorReviewTitle")
            val visitorReviewTitle: String
        )
        @Serializable
        data class MenuInfo(
            @SerialName("menuId")
            val menuId: Int,
            @SerialName("menuImgUrl")
            val menuImgUrl: String,
            @SerialName("menuName")
            val menuName: String,
            @SerialName("menuPrice")
            val menuPrice: Int
        )
        @Serializable
        data class VisitorReviewInfo(
            @SerialName("visitorReviewAuthor")
            val visitorReviewAuthor: String,
            @SerialName("visitorReviewAuthorThumbnail")
            val visitorReviewAuthorThumbnail: String,
            @SerialName("visitorReviewContent")
            val visitorReviewContent: String,
            @SerialName("visitorReviewId")
            val visitorReviewId: Int,
            @SerialName("visitorReviewImgUrl")
            val visitorReviewImgUrl: String
        )
    }
}