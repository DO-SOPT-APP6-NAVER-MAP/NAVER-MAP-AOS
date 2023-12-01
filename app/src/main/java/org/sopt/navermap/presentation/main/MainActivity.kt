package org.sopt.navermap.presentation.main

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import coil.load
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.sopt.dosopttemplate.util.binding.DataBindingFragment
import org.sopt.navermap.R
import org.sopt.navermap.databinding.ActivityMainBinding
import org.sopt.navermap.presentation.detail.DetailActivity
import org.sopt.navermap.presentation.search.result.SearchMapFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var behavior: BottomSheetBehavior<LinearLayout>
    private val viewModel: MainActivityViewModel by viewModels { MainViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.etMainSearchBox.setOnFocusChangeListener { view, b ->
            if(b){
                binding.fcvSearchMain.isVisible = true
            } else {
                binding.fcvSearchMain.isGone = true
            }
        }
        setTextWatcher()
        commitFragment(MainsearchglassFragment())
        initSearchView()
        initSimpleDataObserver()
    }

    private fun setTextWatcher() {
        val editText = binding.etMainSearchBox

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.isBlank() == true) {
                    replaceFragment(MainsearchglassFragment())
                } else {
                    viewModel.setEnteredName(s.toString())
                    replaceFragment(MainsearchFragment())
                }
            }
        })
    }

    private fun <T : ViewDataBinding> commitFragment(fragment: DataBindingFragment<T>) {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_search_main)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction().add(R.id.fcv_search_main, fragment).commit()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fcv_search_main, fragment).commit()
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

    fun clear(){
        binding.etMainSearchBox.clearFocus()
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
                        val intent = Intent(this@MainActivity, DetailActivity::class.java)
                        intent.putExtra("placeId", 1)
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