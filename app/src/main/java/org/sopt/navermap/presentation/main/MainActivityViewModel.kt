package org.sopt.navermap.presentation.main

import androidx.lifecycle.ViewModel
import org.sopt.navermap.data.model.local.Location

class MainActivityViewModel: ViewModel() {
    val mockLocationList = mutableListOf<Location>(
        Location(
            1, "알고리즘", "서울 강남구 도산대로49길 8 2층", "31km", "퓨전음식", 12, 1
        ), Location(
            2, "알고", "서울 강동구 천호대로151길 19 2층", "4.4km", "장난감", 466, 1
        )

    )
}