package org.sopt.navermap.data.repository

import org.sopt.navermap.data.service.DetailService

class DetailRepository(
    private val detailService: DetailService
) {
    suspend fun getDetail(placeId: Int) =
        runCatching {
            detailService.getDetail(placeId)
        }
}