package org.sopt.navermap.presentation.search.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.navermap.data.ServicePool
import org.sopt.navermap.data.repository.SimpleRepository

class TestSearchViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TestSearchViewModel::class.java)) {
            return TestSearchViewModel(
                SimpleRepository(
                    ServicePool.simpleService
                )
            ) as T
        } else {
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}