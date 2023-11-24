package org.sopt.navermap.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import org.sopt.dosopttemplate.util.binding.DataBindingFragment
import org.sopt.navermap.R
import org.sopt.navermap.databinding.FragmentMainSearchBinding


class MainsearchFragment :
    DataBindingFragment<FragmentMainSearchBinding>(R.layout.fragment_main_search) {
    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentFragment = childFragmentManager.findFragmentById(R.id.fcv_main_search_result_grid)
        if (currentFragment == null ) {
            childFragmentManager.beginTransaction()
                .add(R.id.fcv_main_search_result_grid, MainsearchgridFragment())
                .commit()
        }
        val secondCurrentFragment = childFragmentManager.findFragmentById(R.id.fcv_main_search_result_list)
        if (currentFragment == null ) {
            childFragmentManager.beginTransaction()
                .add(R.id.fcv_main_search_result_list, MainsearchlistFragment())
                .commit()
        }
    }
}