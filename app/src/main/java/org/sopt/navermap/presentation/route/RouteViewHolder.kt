package org.sopt.navermap.presentation.route

import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.navermap.data.model.remote.response.DirectionLists
import org.sopt.navermap.databinding.ItemRouteBinding

class RouteViewHolder(private val binding: ItemRouteBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: DirectionLists) {
        binding.ivRouteToAlgo.load(item.route) {
            crossfade(true)
        }
    }
}