package org.sopt.navermap.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.navermap.data.ServicePool
import org.sopt.navermap.data.repository.SimpleRepository

class MainViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(
                SimpleRepository(
                    ServicePool.simpleService
                )
            ) as T
        } else {
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}