package org.sopt.navermap.data.service

import org.sopt.navermap.data.model.remote.response.ResponseGetSimpleDto
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleService {

    @GET("/api/place/{placeId}")
    suspend fun getSimple(
        @Path("placeId") placeId: Int
    ): ResponseGetSimpleDto
}