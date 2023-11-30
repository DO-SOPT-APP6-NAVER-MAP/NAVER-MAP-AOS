package org.sopt.navermap.presentation.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.navermap.data.model.local.Location
import org.sopt.navermap.data.model.remote.response.ResponseSearchNameDto
import org.sopt.navermap.data.repository.SearchNameRepository

class MainActivityViewModel(
    private val searchNameRepository: SearchNameRepository
) : ViewModel() {
    private val _enteredName: MutableLiveData<String> = MutableLiveData()
    val enteredName: MutableLiveData<String> get() = _enteredName

    private val _searchNameResultList = MutableLiveData<List<ResponseSearchNameDto.ResponseData>>()
    val searchNameResultList: MutableLiveData<List<ResponseSearchNameDto.ResponseData>> get() = _searchNameResultList
    private val _searchNameSuccess = MutableLiveData<Boolean>()
    val searchNameSuccess: MutableLiveData<Boolean> get() = _searchNameSuccess

    val mockLocationList = mutableListOf<Location>(
        Location(
            1, "알고", "리즘", "서울 강남구 도산대로49길 8 2층", "31km", "퓨전음식", 12
        ),
        Location(
            2, "알고", "", "서울 강동구 천호대로151길 19 2층", "4.4km", "장난감", 466
        ),
        Location(
            1, "알고", "리즘", "서울 강남구 도산대로49길 8 2층", "31km", "퓨전음식", 12
        ),
        Location(
            2, "알고", "", "서울 강동구 천호대로151길 19 2층", "4.4km", "장난감", 466
        ),
        Location(
            1, "알고", "리즘", "서울 강남구 도산대로49길 8 2층", "31km", "퓨전음식", 12
        ),
        Location(
            2, "알고", "", "서울 강동구 천호대로151길 19 2층", "4.4km", "장난감", 466
        ),
        Location(
            1, "알고", "리즘", "서울 강남구 도산대로49길 8 2층", "31km", "퓨전음식", 12
        ),
        Location(
            2, "알고", "", "서울 강동구 천호대로151길 19 2층", "4.4km", "장난감", 466
        ),
        Location(
            1, "알고", "리즘", "서울 강남구 도산대로49길 8 2층", "31km", "퓨전음식", 12
        ),
        Location(
            2, "알고", "", "서울 강동구 천호대로151길 19 2층", "4.4km", "장난감", 466
        ),
        Location(
            1, "알고", "리즘", "서울 강남구 도산대로49길 8 2층", "31km", "퓨전음식", 12
        ),
        Location(
            2, "알고", "", "서울 강동구 천호대로151길 19 2층", "4.4km", "장난감", 466
        ),
        Location(
            1, "알고", "리즘", "서울 강남구 도산대로49길 8 2층", "31km", "퓨전음식", 12
        ),
        Location(
            2, "알고", "", "서울 강동구 천호대로151길 19 2층", "4.4km", "장난감", 466
        ),

        )

    fun setEnteredName(text: String) {
        _enteredName.value = text
    }
    fun searchName() {
        viewModelScope.launch {
            searchNameRepository.searchName()
                .onSuccess {
                    _searchNameResultList.value = it.data
                    _searchNameSuccess.value = true
                }.onFailure {
                    Log.e("서버통신", "${it.message}")
                    _searchNameSuccess.value = false
                }
        }
    }

}