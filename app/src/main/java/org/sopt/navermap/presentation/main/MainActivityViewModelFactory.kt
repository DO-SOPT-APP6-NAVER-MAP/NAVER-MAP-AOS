//package org.sopt.navermap.presentation.detail
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import org.sopt.navermap.data.ServicePool
//import org.sopt.navermap.data.repository.SearchNameRepository
//import org.sopt.navermap.presentation.main.MainActivityViewModel
//
//class MainActivityViewModelFactory : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
//            val repository =
//                SearchNameRepository(ServicePool.searchNameService)
//            return MainActivityViewModel(repository) as T
//        } else {
//            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
//        }
//    }
//}