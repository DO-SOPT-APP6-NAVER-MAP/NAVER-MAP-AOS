package org.sopt.navermap.presentation.search.result

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.activity.viewModels
import coil.load
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.sopt.dosopttemplate.util.binding.DataBindingActivity
import org.sopt.navermap.R
import org.sopt.navermap.data.model.local.SearchResult
import org.sopt.navermap.databinding.ActivityTestSearchBinding

class TestSearchActivity :
    DataBindingActivity<ActivityTestSearchBinding>(R.layout.activity_test_search){
    private lateinit var behavior: BottomSheetBehavior<LinearLayout>
    private val viewModel: TestSearchViewModel by viewModels { TestSearchViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel

        initSearchView()
        initSimpleDataObserver()
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

    private fun initSimpleDataObserver() {
        viewModel.getSimple(1)
        viewModel.getSimpleData.observe(this) { data ->
            with(binding) {
                tvSearchName.text = data.name
                tvSearchCategory.text = data.category
                tvSearchDescription.text = data.description
                tvSearchDistance.text = data.distance
                tvSearchAddress.text = data.address
                tvSearchStars.text = data.stars
                tvSearchVisitorReview.text = "방문자 리뷰 ${data.visitorReview}"
                tvSearchBlogReview.text = "블로그 리뷰 ${data.blogReview}"
                ivSearchImage1.load(data.previewImgs[0].previewImgUrl)
                ivSearchImage2.load(data.previewImgs[1].previewImgUrl)
                ivSearchImage3.load(data.previewImgs[2].previewImgUrl)
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