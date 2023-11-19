package org.sopt.navermap.util.activity

import android.app.Activity
import android.view.View
import org.sopt.navermap.util.context.hideKeyboard

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}