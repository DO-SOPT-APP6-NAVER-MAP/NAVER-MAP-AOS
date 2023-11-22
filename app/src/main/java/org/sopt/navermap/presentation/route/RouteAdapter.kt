package org.sopt.navermap.presentation.route

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.sopt.navermap.data.model.remote.request.RequestRouteImg
import org.sopt.navermap.databinding.ItemRouteBinding

class RouteAdapter(private val routeList: List<RequestRouteImg>) :
    RecyclerView.Adapter<RouteAdapter.RouteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRouteBinding.inflate(inflater, parent, false)
        return RouteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RouteViewHolder, position: Int) {
        val requestRouteImg = routeList[position]
        holder.bind(requestRouteImg)
    }

    override fun getItemCount(): Int {
        return routeList.size
    }

    inner class RouteViewHolder(private val binding: ItemRouteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val imageView: ImageView = binding.ivRouteToAlgo

        fun bind(item: RequestRouteImg) {
            Glide.with(imageView.context)
                .load(item.img_url)
                .apply(RequestOptions.centerCropTransform())
                .into(imageView)
        }
    }
}