package org.sopt.navermap.presentation.route

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.navermap.data.ServicePool
import org.sopt.navermap.data.repository.RouteRepository

class RouteViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RouteViewModel::class.java)) {
            val repository =
                RouteRepository(ServicePool.routeService)
            return RouteViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}

