package org.sopt.navermap.presentation.search.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestSearchViewModel: ViewModel() {

    var isBtnClicked: MutableLiveData<Boolean> = MutableLiveData(false)


}