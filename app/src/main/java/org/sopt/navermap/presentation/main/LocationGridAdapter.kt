package org.sopt.navermap.presentation.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.navermap.data.model.remote.response.ResponseSearchNameDto
import org.sopt.navermap.databinding.ItemResultGridBinding

class LocationGridAdapter(private val context: Context, private val enteredName: String) :
    RecyclerView.Adapter<LocationGridViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    // 임시의 빈 리스트
    private var locationList: List<ResponseSearchNameDto.ResponseData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationGridViewHolder {
        val binding = ItemResultGridBinding.inflate(inflater, parent, false)
        return LocationGridViewHolder(binding, context, enteredName)
    }

    override fun onBindViewHolder(holder: LocationGridViewHolder, position: Int) {
        holder.onBind(locationList[position])
    }

    override fun getItemCount() = locationList.size

    fun setLocationList(locationList: List<ResponseSearchNameDto.ResponseData>) {
        this.locationList = locationList.toList()
        notifyDataSetChanged()
    }
}