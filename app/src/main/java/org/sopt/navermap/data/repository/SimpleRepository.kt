package org.sopt.navermap.data.repository

import org.sopt.navermap.data.service.SimpleService

class SimpleRepository (
    private val simpleService: SimpleService
){

    suspend fun getSimple(placeId: Int) = runCatching {
        simpleService.getSimple(placeId).getSimpleData()
    }
}