package com.example.trivo.metaweather.network.api

import com.example.trivo.metaweather.model.Location
import com.example.trivo.metaweather.model.WeatherResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MetaWeatherApi {

    @GET("api/location/{locationId}")
    fun getWeather(@Path("locationId") locationId:Int) : Observable<WeatherResponse>

    @GET("api/location/search") fun getLocation(@Query("query") city : String) : Observable<List<Location>>

}