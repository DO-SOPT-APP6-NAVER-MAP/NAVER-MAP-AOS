package org.sopt.navermap.presentation.main

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import org.sopt.navermap.data.model.remote.response.ResponseSearchNameDto
import org.sopt.navermap.databinding.ItemResultGridBinding
import org.sopt.navermap.util.view.Spann.getEnd
import org.sopt.navermap.util.view.Spann.getStart
import org.sopt.navermap.util.view.Spann.setNameColor

class LocationGridViewHolder(
    private val binding: ItemResultGridBinding,
    private val context: Context,
    private val enteredName: String
) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(locationData: ResponseSearchNameDto.ResponseData) {
        binding.tvMainSearchGridTitleEntered.text = locationData.name
        setNameColor(
            binding.tvMainSearchGridTitleEntered,
            getStart(enteredName, locationData.name),
            getEnd(enteredName, locationData.name),
            context
        )
    }


}