package org.sopt.navermap.presentation.search.result

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.navermap.data.model.local.SearchResult
import org.sopt.navermap.data.repository.SimpleRepository

class TestSearchViewModel(
    private val simpleRepository: SimpleRepository
) : ViewModel() {

    var isBtnClicked: MutableLiveData<Boolean> = MutableLiveData(false)

    private val _getSimpleData = MutableLiveData<SearchResult>()
    val getSimpleData: LiveData<SearchResult>
        get() = _getSimpleData


    fun getSimple(placeId: Int) {
        viewModelScope.launch {
            simpleRepository.getSimple(placeId).onSuccess { response ->
                _getSimpleData.value = response
                Log.d(SIMPLE_DATA_TAG, MSG_SUCCESS)
            }.onFailure {
                Log.d(SIMPLE_DATA_TAG, MSG_FAILURE)
            }
        }
    }

    companion object {
        const val SIMPLE_DATA_TAG = "simple viewModel: "
        const val MSG_SUCCESS = "성공"
        const val MSG_FAILURE = "실패"
    }

}