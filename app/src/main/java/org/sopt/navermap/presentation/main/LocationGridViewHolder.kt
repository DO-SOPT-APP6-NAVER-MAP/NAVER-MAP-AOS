package org.sopt.navermap.presentation.main

import androidx.recyclerview.widget.RecyclerView
import org.sopt.navermap.data.model.local.Location
import org.sopt.navermap.databinding.ItemResultGridBinding

class LocationGridViewHolder(private val binding: ItemResultGridBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(locationData: Location) {
        binding.tvMainSearchGridTitle.text = locationData.name
    }
}