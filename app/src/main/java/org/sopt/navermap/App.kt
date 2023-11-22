package org.sopt.navermap

import android.app.Application
import com.naver.maps.map.NaverMapSdk

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        NaverMapSdk.getInstance(this).client =
            NaverMapSdk.NaverCloudPlatformClient(BuildConfig.NAVER_CLIENT_ID)

    }
}