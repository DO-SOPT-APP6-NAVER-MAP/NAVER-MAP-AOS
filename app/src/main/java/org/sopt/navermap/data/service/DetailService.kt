package org.sopt.navermap.data.service

import org.sopt.navermap.data.model.remote.response.ResponseGetDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailService {
    @GET("/api/place/{placeId}/detail")
    suspend fun getDetail(
        @Path("placeId") placeId: Int
    ): ResponseGetDetailDto
}