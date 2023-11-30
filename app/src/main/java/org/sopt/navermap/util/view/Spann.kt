package org.sopt.navermap.util.view

import android.content.Context
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.sopt.navermap.R

object Spann {
    fun setNameColor(textView: TextView, start: Int, end: Int, context: Context) {
        val textData = textView.text
        val builder = SpannableStringBuilder(textData)
        val blue = ContextCompat.getColor(context, R.color.blue)
        val colorBlueSpan = ForegroundColorSpan(blue)
        builder.setSpan(colorBlueSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

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

        for (i in 0 until minLength) {
            if (objectString[objectString.length-1] == baseString[i]) {
                return i
            }
        }
        return 0

    }
}