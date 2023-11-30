package org.sopt.navermap.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import org.sopt.dosopttemplate.util.binding.DataBindingFragment
import org.sopt.navermap.R
import org.sopt.navermap.databinding.FragmentMainSearchBinding
import org.sopt.navermap.presentation.detail.MainActivityViewModelFactory


class MainsearchFragment :
    DataBindingFragment<FragmentMainSearchBinding>(R.layout.fragment_main_search) {
    private val viewModel: MainActivityViewModel by viewModels { MainActivityViewModelFactory() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.searchName()
        initSearchNameSuccessObserver()
    }

    private fun initSearchNameSuccessObserver() {
        viewModel.searchNameSuccess.observe(viewLifecycleOwner) {
            if (it) {
                initRecyclerView()
            }
        }
    }


    private fun initRecyclerView() {
        initGridAdapter()
        initListAdapter()
    }

    private fun initListAdapter() {
        val locationListAdapter =
            LocationListAdapter(requireContext(), viewModel.enteredName.value ?: "")
        binding.rvMainSearchList.adapter = locationListAdapter
        locationListAdapter.setLocationList(requireNotNull(viewModel.searchNameResultList.value))
    }

    private fun initGridAdapter() {
        val locationGridAdapter =
            LocationGridAdapter(requireContext(), viewModel.enteredName.value ?: "")
        binding.rvMainSearchGrid.adapter = locationGridAdapter
        locationGridAdapter.setLocationList(
            requireNotNull(viewModel.searchNameResultList.value).subList(
                0, 4
            )
        )
    }
}