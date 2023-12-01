// RouteViewModel.kt
package org.sopt.navermap.presentation.route

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.sopt.navermap.data.model.remote.response.DirectionLists
import org.sopt.navermap.data.repository.RouteRepository

class RouteViewModel(private val routeRepository: RouteRepository) : ViewModel() {

    private val _directionLists = MutableLiveData<List<DirectionLists>>()
    val directionLists: LiveData<List<DirectionLists>> get() = _directionLists

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun getDirectionLists() {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                routeRepository.getDirectionLists(1)
            }
            response.onSuccess { result ->
                _directionLists.value = result.data.directionLists
                Log.d("route success", "${result.data}")
            }
            response.onFailure { throwable ->
                _error.value = throwable.message
                Log.d("route fail", "${throwable}")
            }
        }
    }
}
