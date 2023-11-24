package org.sopt.navermap.presentation.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.navermap.data.model.local.Location
import org.sopt.navermap.databinding.ItemResultGridBinding
import org.sopt.navermap.databinding.ItemResultListBinding

class LocationAdapter(context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var locationList: List<Location> = emptyList()
    private lateinit var itemResultGridBinding: ItemResultGridBinding
    private lateinit var itemResultListBinding: ItemResultListBinding
    private var type = GRID

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var myView = setViewHolder(parent, viewType)
        return myView
    }

    private fun setViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            GRID -> {
                setGridViewHolder(parent)
            }

            LIST -> {
                setListViewHolder(parent)
            }

            else -> {
                throw RuntimeException("알 수 없는 view type error")
            }
        }
    }

    private fun setListViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        itemResultListBinding = ItemResultListBinding.inflate(inflater, parent, false)
        return ResultListViewHolder(itemResultListBinding)
    }

    private fun setGridViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        itemResultGridBinding = ItemResultGridBinding.inflate(inflater, parent, false)
        return ResultGridViewHolder(itemResultGridBinding)
    }

    override fun getItemViewType(position: Int): Int = when (locationList[position].type) {
        Companion.GRID -> GRID
        else -> LIST
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ResultGridViewHolder -> holder.onBind(locationList[position])
            is ResultListViewHolder -> holder.onBind(locationList[position])
        }
    }

    override fun getItemCount() = locationList.size

    fun setProfileList(profileList: List<Location>) {
        this.locationList = profileList.toList()
        notifyDataSetChanged()
    }
    companion object {
        const val GRID = 1
        const val LIST = 0
    }
}