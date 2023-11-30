package org.sopt.navermap.data.service

import org.sopt.navermap.data.model.remote.response.ResponseSearchNameDto
import retrofit2.http.GET

interface SearchNameService {
    @GET("/api/place?name=알고")
    suspend fun searchName(): ResponseSearchNameDto
}