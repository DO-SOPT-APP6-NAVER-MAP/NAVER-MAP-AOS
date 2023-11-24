package org.sopt.navermap.presentation.main

import androidx.recyclerview.widget.RecyclerView
import org.sopt.navermap.data.model.local.Location
import org.sopt.navermap.databinding.ItemResultListBinding

class LocationListViewHolder(private val binding: ItemResultListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(locationData: Location) {
        binding.tvMainSearchListTitle.text = locationData.name
        binding.tvMainSearchAddress.text = locationData.address
        binding.tvMainSearchReviewInt.text = locationData.review.toString()
        binding.tvMainSearchCategory.text = locationData.category
        binding.tvMainSearchDistance.text = locationData.distance
    }
}