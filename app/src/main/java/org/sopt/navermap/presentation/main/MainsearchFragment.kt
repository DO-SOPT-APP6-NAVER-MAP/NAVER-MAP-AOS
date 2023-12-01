package org.sopt.navermap.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import org.sopt.dosopttemplate.util.binding.DataBindingFragment
import org.sopt.navermap.R
import org.sopt.navermap.databinding.FragmentMainSearchBinding


class MainsearchFragment :
    DataBindingFragment<FragmentMainSearchBinding>(R.layout.fragment_main_search) {
    private val viewModel: MainActivityViewModel by activityViewModels()
    private lateinit var enteredName: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
        viewModel.searchName()
        initSearchNameSuccessObserver()
        enteredName = viewModel.enteredName.value ?: ""
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
        val locationListAdapter = LocationListAdapter(requireContext(), enteredName, onClicked = { recyclerViewItemClickHandler() })
        binding.rvMainSearchList.adapter = locationListAdapter
        locationListAdapter.setLocationList(requireNotNull(viewModel.searchNameResultList.value))
    }

    private fun recyclerViewItemClickHandler() {
        val currentFragment = parentFragmentManager.findFragmentById(R.id.fcv_search_main)
        if(currentFragment != null){
            val parentActivity = activity as? MainActivity
            parentActivity?.clear()
            parentFragmentManager.beginTransaction().remove(currentFragment).commit()
            parentFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    private fun initGridAdapter() {
        val locationGridAdapter = LocationGridAdapter(requireContext(), enteredName)
        binding.rvMainSearchGrid.adapter = locationGridAdapter
        locationGridAdapter.setLocationList(
            requireNotNull(viewModel.searchNameResultList.value).subList(
                0, 4
            )
        )
    }
}