package org.sopt.navermap.presentation.main

import androidx.fragment.app.viewModels
import org.sopt.dosopttemplate.util.binding.DataBindingFragment
import org.sopt.navermap.R
import org.sopt.navermap.databinding.FragmentMainSearchBinding


class MainsearchFragment :
    DataBindingFragment<FragmentMainSearchBinding>(R.layout.fragment_main_search) {
    private val viewModel by viewModels<MainActivityViewModel>()


}