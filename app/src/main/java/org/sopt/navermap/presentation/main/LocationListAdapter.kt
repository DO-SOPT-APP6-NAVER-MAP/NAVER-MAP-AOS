package org.sopt.navermap.presentation.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.navermap.data.model.local.Location
import org.sopt.navermap.data.model.remote.response.ResponseSearchNameDto
import org.sopt.navermap.databinding.ItemResultListBinding

class LocationListAdapter(context: Context) : RecyclerView.Adapter<LocationListViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    // 임시의 빈 리스트
    private var locationList: List<ResponseSearchNameDto.ResponseData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationListViewHolder {
        val binding = ItemResultListBinding.inflate(inflater, parent, false)
        return LocationListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationListViewHolder, position: Int) {
        holder.onBind(locationList[position])
    }

    override fun getItemCount() = locationList.size

    fun setLocationList(locationList: List<ResponseSearchNameDto.ResponseData>) {
        this.locationList = locationList.toList()
        notifyDataSetChanged()
    }
}