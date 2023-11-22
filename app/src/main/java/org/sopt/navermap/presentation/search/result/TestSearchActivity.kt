package org.sopt.navermap.presentation.search.result

import android.os.Bundle
import org.sopt.dosopttemplate.util.binding.DataBindingActivity
import org.sopt.navermap.R
import org.sopt.navermap.databinding.ActivityTestSearchBinding

class TestSearchActivity :
    DataBindingActivity<ActivityTestSearchBinding>(R.layout.activity_test_search) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        initSearchView()

    }

    private fun initSearchView() {
        makeMapView()
        makeBottomSheet()
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
        val currentBottomFragment = supportFragmentManager.findFragmentById(R.id.fcv_search_bottom)
        if (currentBottomFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_search_bottom, SearchBottomFragment())
                .commit()
        }
    }
}