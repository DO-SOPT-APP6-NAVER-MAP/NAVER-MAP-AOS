package org.sopt.navermap.presentation.route

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.sopt.navermap.databinding.ActivityRouteBinding

class RouteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRouteBinding
    private lateinit var routeAdapter: RouteAdapter
    private lateinit var routeViewModel: RouteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRouteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // API 호출
        routeViewModel.getDirectionLists()
        // RecyclerView 초기화
        routeAdapter = RouteAdapter(emptyList()) // 초기에 빈 리스트로 설정
        binding.rcRouteImg.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcRouteImg.adapter = routeAdapter

        val viewModelFactory = RouteViewModelFactory()
        routeViewModel = ViewModelProvider(this, viewModelFactory)
            .get(RouteViewModel::class.java)

        routeViewModel.directionLists.observe(this) { directionLists ->
            routeAdapter.setData(directionLists)
        }

        routeViewModel.error.observe(this) { error ->
            Log.e("RouteActivity", "API call failed: $error")
        }


    }
}