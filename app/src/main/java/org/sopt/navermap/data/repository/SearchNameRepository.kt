package org.sopt.navermap.data.repository

import org.sopt.navermap.data.service.SearchNameService

class SearchNameRepository(
    private val searchNameService: SearchNameService
) {
    suspend fun searchName() =
        runCatching {
            searchNameService.searchName()
        }
}