package org.sopt.navermap.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.navermap.data.model.remote.response.ResponseGetDetailDto
import org.sopt.navermap.data.repository.DetailRepository

class DetailViewModel(
    private val detailRepository: DetailRepository
) : ViewModel() {
    private val _getDetailResult = MutableLiveData<ResponseGetDetailDto>()
    val getDetailResult: LiveData<ResponseGetDetailDto> get() = _getDetailResult

    private val _getDetailSuccess = MutableLiveData<Boolean>()
    val getDetailSuccess: LiveData<Boolean> get() = _getDetailSuccess

    fun getDetail(placeId: Int) {
        viewModelScope.launch {
            detailRepository.getDetail(placeId)
                .onSuccess {
                    Log.e("서버통신","성공")
                    _getDetailResult.value = it
                    _getDetailSuccess.value = true
                }
                .onFailure {
                    Log.e("서버통신","${it.message}")
                    _getDetailSuccess.value = false
                }
        }

    }
}