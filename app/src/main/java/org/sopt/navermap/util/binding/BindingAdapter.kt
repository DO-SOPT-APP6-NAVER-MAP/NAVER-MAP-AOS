package org.sopt.navermap.util.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation

@BindingAdapter("setImageUrl")
fun ImageView.setImageUrl(imageUrl: String?) {
    if (imageUrl == null) {
        return
    } else {
        load(imageUrl) {
            transformations(RoundedCornersTransformation(10F))
        }
    }
}

@BindingAdapter("setImageUrlNoRadius")
fun ImageView.setImageUrlNoRadius(imageUrl: String?) {
    if (imageUrl == null) {
        return
    } else {
        load(imageUrl)
    }
}