package org.sopt.navermap.presentation.search.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.navermap.data.model.local.SearchResult

class TestSearchViewModel : ViewModel() {

    var isBtnClicked: MutableLiveData<Boolean> = MutableLiveData(false)

    private val _mockSearchReultList: MutableLiveData<SearchResult> = MutableLiveData(
            SearchResult(
                    "알고",
                    "서울 광진구",
                    "서울 광진구 광나루로17길 10",
                    "936m",
                    "스파게티, 파스타 전문",
                    "수제 맥주를 즐길 수 있는 어린이대공원 파스타 맛집",
                    288,
                    316,
                    listOf("image_url1", "image_url2", "image_url3"),
                    4.82
            )
    )

    val mockSearchResult: LiveData<SearchResult>
        get() = _mockSearchReultList

}