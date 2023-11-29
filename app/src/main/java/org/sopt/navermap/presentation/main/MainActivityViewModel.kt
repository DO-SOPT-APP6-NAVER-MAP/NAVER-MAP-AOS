package org.sopt.navermap.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.navermap.data.ServicePool.searchNameService
import org.sopt.navermap.data.model.local.Location

class MainActivityViewModel : ViewModel() {
    val name: MutableLiveData<String> = MutableLiveData()

    val mockLocationList = mutableListOf<Location>(
        Location(
            1, "알고","리즘", "서울 강남구 도산대로49길 8 2층", "31km", "퓨전음식", 12
        ),
        Location(
            2, "알고","", "서울 강동구 천호대로151길 19 2층", "4.4km", "장난감", 466
        ),
        Location(
            1, "알고","리즘", "서울 강남구 도산대로49길 8 2층", "31km", "퓨전음식", 12
        ),
        Location(
            2, "알고","", "서울 강동구 천호대로151길 19 2층", "4.4km", "장난감", 466
        ),
        Location(
            1, "알고","리즘", "서울 강남구 도산대로49길 8 2층", "31km", "퓨전음식", 12
        ),
        Location(
            2, "알고","", "서울 강동구 천호대로151길 19 2층", "4.4km", "장난감", 466
        ),
        Location(
            1, "알고","리즘", "서울 강남구 도산대로49길 8 2층", "31km", "퓨전음식", 12
        ),
        Location(
            2, "알고","", "서울 강동구 천호대로151길 19 2층", "4.4km", "장난감", 466
        ),
        Location(
            1, "알고","리즘", "서울 강남구 도산대로49길 8 2층", "31km", "퓨전음식", 12
        ),
        Location(
            2, "알고","", "서울 강동구 천호대로151길 19 2층", "4.4km", "장난감", 466
        ),
        Location(
            1, "알고","리즘", "서울 강남구 도산대로49길 8 2층", "31km", "퓨전음식", 12
        ),
        Location(
            2, "알고","", "서울 강동구 천호대로151길 19 2층", "4.4km", "장난감", 466
        ),
        Location(
            1, "알고","리즘", "서울 강남구 도산대로49길 8 2층", "31km", "퓨전음식", 12
        ),
        Location(
            2, "알고","", "서울 강동구 천호대로151길 19 2층", "4.4km", "장난감", 466
        ),

    )

    fun searchName() {
//        viewModelScope.launch {
//            kotlin.runCatching {
//                searchNameService.searchName()
//            }.onSuccess {
//                if (it.isSuccessful) {
//                    signUpResult.value = it.body()
//                    signUpSuccess.value = true
//                } else {
//                    signUpSuccess.value = false
//                }
//            }.onFailure {
//                // 에러 처리
//            }
//        }
    }

}