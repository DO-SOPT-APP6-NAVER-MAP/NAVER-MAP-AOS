package org.sopt.navermap.presentation.search.result

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.navermap.data.model.local.SearchResult
import org.sopt.navermap.data.model.remote.response.ResponseGetSimpleDto
import org.sopt.navermap.data.repository.SimpleRepository

class TestSearchViewModel(
    private val simpleRepository: SimpleRepository
) : ViewModel() {

    var isBtnClicked: MutableLiveData<Boolean> = MutableLiveData(false)

    private val _getSimpleData = MutableLiveData<ResponseGetSimpleDto>()
    val getSimpleData: LiveData<ResponseGetSimpleDto>
        get() = _getSimpleData

//    private val _mockSearchReultList: MutableLiveData<SearchResult> = MutableLiveData(
//            SearchResult(
//                    "알고",
//                    "서울 광진구",
//                    "서울 광진구 광나루로17길 10",
//                    "936m",
//                    "스파게티, 파스타 전문",
//                    "수제 맥주를 즐길 수 있는 어린이대공원 파스타 맛집",
//                    288,
//                    316,
//                    listOf("image_url1", "image_url2", "image_url3"),
//                    4.82
//            )
//    )
//
//    val mockSearchResult: LiveData<SearchResult>
//        get() = _mockSearchReultList

    fun getSimple(placeId: Int) {
        viewModelScope.launch {
            simpleRepository.getSimple(placeId).onSuccess {
                _getSimpleData.value = it
                Log.d("simple viewModel: ", "성공")
            }.onFailure {
                Log.d("simple viewModel: ", "실패")
            }
        }
    }

}