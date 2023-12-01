package org.sopt.navermap.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.navermap.data.ServicePool
import org.sopt.navermap.data.repository.DetailRepository

class DetailViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            val repository =
                DetailRepository(ServicePool.detailService)
            return DetailViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}