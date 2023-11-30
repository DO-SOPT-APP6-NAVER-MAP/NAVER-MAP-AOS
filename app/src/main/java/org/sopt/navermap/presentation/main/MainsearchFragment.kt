package org.sopt.navermap.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import org.sopt.dosopttemplate.util.binding.DataBindingFragment
import org.sopt.navermap.R
import org.sopt.navermap.databinding.FragmentMainSearchBinding


class MainsearchFragment :
    DataBindingFragment<FragmentMainSearchBinding>(R.layout.fragment_main_search) {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var enteredName: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
        viewModel.searchName()
        initSearchNameSuccessObserver()
        enteredName = arguments?.getString("enteredName").toString()
        Log.v("entered name", enteredName)

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
            LocationListAdapter(requireContext(), enteredName)
        binding.rvMainSearchList.adapter = locationListAdapter
        locationListAdapter.setLocationList(requireNotNull(viewModel.searchNameResultList.value))
    }

    private fun initGridAdapter() {
        val locationGridAdapter =
            LocationGridAdapter(requireContext(), enteredName)
        binding.rvMainSearchGrid.adapter = locationGridAdapter
        locationGridAdapter.setLocationList(
            requireNotNull(viewModel.searchNameResultList.value).subList(
                0, 4
            )
        )
    }
}