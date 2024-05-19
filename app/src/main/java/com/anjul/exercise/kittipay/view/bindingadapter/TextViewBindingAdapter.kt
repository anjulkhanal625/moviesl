package com.anjul.exercise.kittipay.view.bindingadapter

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.anjul.exercise.kittipay.extensions.toHoursAndMinutesString

@BindingAdapter("runTime")
fun setRunTime(view: TextView, runTime: Int?) {
    runTime?.let {
        val txt = it.toHoursAndMinutesString()
        if (txt.trim().isNullOrBlank()) view.visibility = View.GONE else view.text = txt
    }
}
