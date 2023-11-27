package org.sopt.navermap.data.model.local

data class SearchResult(
        val name: String = "",
        val address: String = "",
        val detail_address: String = "",
        val distance: String = "",
        val category: String = "",
        val description: String = "",
        val visitor_review: Int = 0,
        val blog_review: Int = 0,
        val images: List<String>,
        val stars: Double = 0.0
)