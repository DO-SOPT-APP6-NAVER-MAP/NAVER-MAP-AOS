package org.sopt.navermap.data.model.local

data class SearchResult(
    val name: String = "",
    val category: String = "",
    val description: String = "",
    val distance: String = "",
    val address: String = "",
    val closeTime: String = "",
    val stars: String = "",
    val visitorReview: Int = 0,
    val blogReview: Int = 0,
    val previewImgs: List<Image>
) {
    data class Image(
        val previewId: Int = 0,
        val previewImgUrl: String = ""
    )
}