package com.example.trivo.metaweather.model

data class Weather(val city:String, val weather: ConsolidatedWeather){
    val imageUrl:String
    get() = "https://www.metaweather.com/static/img/weather/png/"+weather.weather_state_abbr+".png"
}
