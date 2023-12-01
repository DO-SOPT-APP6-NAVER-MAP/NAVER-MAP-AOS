package org.sopt.navermap.presentation.main

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import org.sopt.navermap.data.model.remote.response.ResponseSearchNameDto
import org.sopt.navermap.databinding.ItemResultListBinding
import org.sopt.navermap.util.view.Spann.getEnd
import org.sopt.navermap.util.view.Spann.getStart
import org.sopt.navermap.util.view.Spann.setNameColor

class LocationListViewHolder(
    private val binding: ItemResultListBinding,
    private val context: Context,
    private val onClicked: (ResponseSearchNameDto.ResponseData) -> Unit,
    private val enteredName: String
) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(locationData: ResponseSearchNameDto.ResponseData) {
        binding.tvMainSearchListTitleEntered.text = locationData.name
        binding.tvMainSearchAddress.text = locationData.detailAddress
        binding.tvMainSearchReviewInt.text = locationData.visitorReview.toString()
        binding.tvMainSearchCategory.text = locationData.category
        binding.tvMainSearchDistance.text = locationData.distance
        setNameColor(
            binding.tvMainSearchListTitleEntered,
            getStart(enteredName, locationData.name),
            getEnd(enteredName, locationData.name),
            context
        )
        binding.root.setOnClickListener {
            onClicked(locationData)
        }
    }
}