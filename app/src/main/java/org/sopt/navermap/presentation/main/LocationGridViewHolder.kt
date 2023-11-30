package org.sopt.navermap.presentation.main

import androidx.recyclerview.widget.RecyclerView
import org.sopt.navermap.data.model.remote.response.ResponseSearchNameDto
import org.sopt.navermap.databinding.ItemResultGridBinding

class LocationGridViewHolder(private val binding: ItemResultGridBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(locationData: ResponseSearchNameDto.ResponseData) {
        binding.tvMainSearchGridTitleEntered.text = locationData.name
        binding.tvMainSearchGridTitle.text = locationData.name
    }
}