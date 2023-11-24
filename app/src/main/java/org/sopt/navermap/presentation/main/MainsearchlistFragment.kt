package org.sopt.navermap.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import org.sopt.dosopttemplate.util.binding.DataBindingFragment
import org.sopt.navermap.R
import org.sopt.navermap.databinding.FragmentMainSearchBinding
import org.sopt.navermap.databinding.FragmentMainSearchGridBinding
import org.sopt.navermap.databinding.FragmentMainSearchListBinding


class MainsearchlistFragment :
    DataBindingFragment<FragmentMainSearchListBinding>(R.layout.fragment_main_search_list) {
    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val locationListAdapter = LocationListAdapter(requireContext())
        binding.rvMainSearchList.adapter = locationListAdapter
        locationListAdapter.setLocationList(viewModel.mockLocationList)
    }
}