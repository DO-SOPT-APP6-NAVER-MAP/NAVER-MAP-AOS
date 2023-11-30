package org.sopt.navermap.presentation.main

import androidx.recyclerview.widget.RecyclerView
import org.sopt.navermap.data.model.local.Location
import org.sopt.navermap.data.model.remote.response.ResponseSearchNameDto
import org.sopt.navermap.databinding.ItemResultListBinding

class LocationListViewHolder(private val binding: ItemResultListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(locationData: ResponseSearchNameDto.ResponseData) {
        binding.tvMainSearchListTitleEntered.text = locationData.name
        binding.tvMainSearchListTitle.text = locationData.name
        binding.tvMainSearchAddress.text = locationData.detailAddress
        binding.tvMainSearchReviewInt.text = locationData.visitorReview.toString()
        binding.tvMainSearchCategory.text = locationData.category
        binding.tvMainSearchDistance.text = locationData.distance
    }
}