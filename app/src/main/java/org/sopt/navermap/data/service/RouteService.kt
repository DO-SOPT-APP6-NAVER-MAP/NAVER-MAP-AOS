package org.sopt.navermap.data.service

import org.sopt.navermap.data.model.remote.response.ResponseRoute
import retrofit2.http.GET
import retrofit2.http.Path

interface RouteService {
    @GET("/api/place/{placeId}/route")
    suspend fun getPlace(
        @Path("placeId") placeId: Int
    ): ResponseRoute
}