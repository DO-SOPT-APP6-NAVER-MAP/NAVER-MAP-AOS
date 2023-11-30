package org.sopt.navermap.presentation.main

import android.content.Context
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import org.sopt.navermap.R
import org.sopt.navermap.data.model.remote.response.ResponseSearchNameDto
import org.sopt.navermap.databinding.ItemResultGridBinding

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

    fun setNameColor(textView: TextView, start: Int, end: Int, context: Context) {
        Log.v("index of start", start.toString())
        Log.v("index of end", end.toString())
        val textData = textView.text
        val builder = SpannableStringBuilder(textData)
        val blue = ContextCompat.getColor(context, R.color.blue)
        val colorBlueSpan = ForegroundColorSpan(blue)
        builder.setSpan(colorBlueSpan, start, end + 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = builder
    }

    fun getStart(objectString: String, baseString: String): Int {
        val minLength = minOf(objectString.length, baseString.length)

        for (i in 0 until minLength) {
            if (objectString[0] == baseString[i]) {
                return i
            }
        }
        return 0

    }

    fun getEnd(objectString: String, baseString: String): Int {
        val minLength = minOf(objectString.length, baseString.length)
        Log.v("object str", objectString)
        for (i in 0 until minLength) {
            if (objectString[objectString.length - 1] == baseString[i]) {
                return i
            }
        }
        return 0

    }

}