package com.example.trivo.metaweather.ui.weather

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.trivo.metaweather.R
import com.example.trivo.metaweather.databinding.ItemWeatherBinding
import com.example.trivo.metaweather.model.Weather

class WeatherAdapter:RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    private var items: List<Weather> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:ItemWeatherBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_weather, parent, false)
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateWeatherItems(items:List<Weather>) {
        this.items = items
        notifyDataSetChanged()
    }

    class WeatherViewHolder(private val binding:ItemWeatherBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(weather:Weather) {
            binding.weatherModel = weather
            binding.executePendingBindings()
        }

    }

}