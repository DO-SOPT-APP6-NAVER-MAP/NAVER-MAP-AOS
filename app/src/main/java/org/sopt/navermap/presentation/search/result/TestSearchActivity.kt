package org.sopt.navermap.presentation.search.result

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.activity.viewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.sopt.dosopttemplate.util.binding.DataBindingActivity
import org.sopt.navermap.R
import org.sopt.navermap.databinding.ActivityTestSearchBinding

class TestSearchActivity :
    DataBindingActivity<ActivityTestSearchBinding>(R.layout.activity_test_search){

    private lateinit var behavior: BottomSheetBehavior<LinearLayout>
    private val viewModel by viewModels<TestSearchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel

        initSearchView()

    }

    private fun initSearchView() {
        makeMapView()
        makeBottomSheet()
        clickBtnDetailAddress()
    }

    private fun makeMapView() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_search_map)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_search_map, SearchMapFragment())
                .commit()
        }
    }

    private fun makeBottomSheet() {
        getSearchResultData()
        behavior = BottomSheetBehavior.from(binding.bottomSheetSearch)
        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Log.d("testActivity: ", "bottomSheet 드래그 중")
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        Log.d("testActivity: ", "bottomSheet 드래그")
                    }

                    BottomSheetBehavior.STATE_EXPANDED -> {
                        Log.d("testActivity: ", "bottomSheet 펼치기 ")
                        val intent = Intent(this@TestSearchActivity, TestSearch2Activity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                        startActivity(intent)
                    }
                }
            }
        })
    }

    private fun getSearchResultData() {
        viewModel.mockSearchResult.observe(this) { data ->
            with(binding) {
                tvSearchName.text = data.name
                tvSearchAddress.text = data.address
                tvSearchDistance.text = data.distance
                tvSearchCategory.text = data.category
                tvSearchDescription.text = data.description
                tvSearchVisitorReview.text = "방문자 리뷰 ${data.visitor_review}"
                tvSearchBlogReview.text = "블로그 리뷰 ${data.blog_review}"
                tvSearchStars.text = data.stars.toString()
            }
        }
    }

    private fun clickBtnDetailAddress() {
        binding.btnSearchDetailAddress.setOnClickListener {
            when (viewModel.isBtnClicked.value) {
                true -> viewModel.isBtnClicked.value = false
                false -> viewModel.isBtnClicked.value = true
                else -> viewModel.isBtnClicked.value = false
            }
        }
    }


}