package org.sopt.navermap.data.repository

import org.sopt.navermap.data.service.RouteService

class RouteRepository (
    private val routeService: RouteService
) {
    suspend fun getDirectionLists(placeId: Int) =
        kotlin.runCatching {
            routeService.getPlace(placeId)
        }
}
