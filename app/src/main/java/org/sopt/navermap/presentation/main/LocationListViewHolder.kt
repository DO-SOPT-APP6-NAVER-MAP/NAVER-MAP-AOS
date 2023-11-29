package org.sopt.navermap.presentation.main

import androidx.recyclerview.widget.RecyclerView
import org.sopt.navermap.data.model.local.Location
import org.sopt.navermap.databinding.ItemResultListBinding

class LocationListViewHolder(private val binding: ItemResultListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(locationData: Location) {
        binding.tvMainSearchListTitleEntered.text = locationData.nameEntered
        binding.tvMainSearchListTitle.text = locationData.nameRemain
        binding.tvMainSearchAddress.text = locationData.detailAddress
        binding.tvMainSearchReviewInt.text = locationData.visitorReview.toString()
        binding.tvMainSearchCategory.text = locationData.category
        binding.tvMainSearchDistance.text = locationData.distance
    }
}