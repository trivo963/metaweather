package com.example.trivo.metaweather.ui.weather

import com.example.trivo.metaweather.base.BaseView
import com.example.trivo.metaweather.model.Weather

interface WeatherView : BaseView {
    fun showLoading(isVisible:Boolean)
    fun showWeather(weather: List<Weather>)
    fun showError(error : String)
}