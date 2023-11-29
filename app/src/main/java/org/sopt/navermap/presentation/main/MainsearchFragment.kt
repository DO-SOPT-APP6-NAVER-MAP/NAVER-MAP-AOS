package org.sopt.navermap.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import org.sopt.dosopttemplate.util.binding.DataBindingFragment
import org.sopt.navermap.R
import org.sopt.navermap.databinding.FragmentMainSearchBinding


class MainsearchFragment :
    DataBindingFragment<FragmentMainSearchBinding>(R.layout.fragment_main_search) {
    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val locationGridAdapter = LocationGridAdapter(requireContext())
        binding.rvMainSearchGrid.adapter = locationGridAdapter
        locationGridAdapter.setLocationList(viewModel.mockLocationList.subList(0, 4))

        val locationListAdapter = LocationListAdapter(requireContext())
        binding.rvMainSearchList.adapter = locationListAdapter
        locationListAdapter.setLocationList(viewModel.mockLocationList)
    }
}