package org.sopt.navermap.data.service

import org.sopt.navermap.data.model.remote.response.ResponseSearchName
import retrofit2.Call
import retrofit2.http.GET

interface SearchNameService {
    @GET("/api/place?name=알고")
    suspend fun searchName(): Call<ResponseSearchName>
}