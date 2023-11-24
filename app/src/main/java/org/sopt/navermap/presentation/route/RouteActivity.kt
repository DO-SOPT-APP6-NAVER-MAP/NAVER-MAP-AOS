package org.sopt.navermap.presentation.route

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.sopt.navermap.data.ApiFactory
import org.sopt.navermap.data.model.remote.request.RequestRouteImg
import org.sopt.navermap.databinding.ActivityRouteBinding

class RouteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRouteBinding
    private lateinit var routeAdapter: RouteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRouteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 더미 데이터로 이미지 URL 리스트 생성
        val dummyImageList = listOf(
            RequestRouteImg("https://picsum.photos/id/237/100/200"),
            RequestRouteImg("https://picsum.photos/id/237/100/200"),
            RequestRouteImg("https://picsum.photos/id/237/100/200")
        )

        routeAdapter = RouteAdapter(dummyImageList)
        binding.rcRouteImg.layoutManager = LinearLayoutManager(this)
        binding.rcRouteImg.adapter = routeAdapter

        /* GlobalScope.launch(Dispatchers.Main) {
            try {
                val imageList = ApiFactory.apiService.getImageData()

                // 어댑터 초기화 및 데이터 설정
                routeAdapter = RouteAdapter(imageList)
                binding.rcRouteImg.adapter = routeAdapter
            } catch (e: Exception) {
                // Handle the exception (e.g., show an error message)
                e.printStackTrace()
            }
        }*/
    }
}