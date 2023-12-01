package org.sopt.navermap.presentation.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.navermap.data.ServicePool
import org.sopt.navermap.data.model.local.Location
import org.sopt.navermap.data.model.remote.response.ResponseSearchNameDto
import org.sopt.navermap.data.repository.SearchNameRepository

class MainActivityViewModel(
//    private val searchNameRepository: SearchNameRepository
) : ViewModel() {
    private val repository = SearchNameRepository(ServicePool.searchNameService)
    private val _enteredName: MutableLiveData<String> = MutableLiveData()
    val enteredName: MutableLiveData<String> get() = _enteredName

    private val _searchNameResultList = MutableLiveData<List<ResponseSearchNameDto.ResponseData>>()
    val searchNameResultList: MutableLiveData<List<ResponseSearchNameDto.ResponseData>> get() = _searchNameResultList
    private val _searchNameSuccess = MutableLiveData<Boolean>()
    val searchNameSuccess: MutableLiveData<Boolean> get() = _searchNameSuccess

    fun setEnteredName(text: String) {
        _enteredName.value = text
    }

    fun searchName() {
        viewModelScope.launch {
            repository.searchName()
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