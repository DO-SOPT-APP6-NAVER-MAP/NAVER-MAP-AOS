// RouteAdapter.kt
package org.sopt.navermap.presentation.route

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import org.sopt.navermap.data.model.remote.response.DirectionLists
import org.sopt.navermap.databinding.ItemRouteBinding

class RouteAdapter(context: List<Any>) : RecyclerView.Adapter<RouteViewHolder>() {

    private var directionLists: List<DirectionLists> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRouteBinding.inflate(inflater, parent, false)
        return RouteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RouteViewHolder, position: Int) {
        val direction = directionLists[position]
        holder.bind(direction)
    }

    override fun getItemCount(): Int {
        return directionLists.size
    }

    fun setData(newList: List<DirectionLists>) {
        val diffResult = DiffUtil.calculateDiff(
            DirectionListsDiffCallback(
                directionLists,
                newList
            )
        )
        directionLists = newList
        diffResult.dispatchUpdatesTo(this)
    }


    private class DirectionListsDiffCallback(
        private val oldList: List<DirectionLists>,
        private val newList: List<DirectionLists>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size
        override fun getNewListSize(): Int = newList.size
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].directionId == newList[newItemPosition].directionId

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]
    }
}
