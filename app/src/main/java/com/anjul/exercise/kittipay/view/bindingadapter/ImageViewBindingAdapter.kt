package com.anjul.exercise.kittipay.view.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    Glide.with(view.context)
        .load("https://image.tmdb.org/t/p/w500$imageUrl")
        .into(view)
}
