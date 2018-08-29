package com.example.trivo.metaweather.util

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.example.trivo.metaweather.ui.weather.WeatherAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: WeatherAdapter) {
    view.adapter = adapter
}

@BindingAdapter("layoutManager")
fun setLayoutManager(view: RecyclerView, layoutManager: RecyclerView.LayoutManager) {
    view.layoutManager = layoutManager
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String) {
    Picasso.get()
            .load(imageUrl)
            .resize(200,200)
            .into(view)
}