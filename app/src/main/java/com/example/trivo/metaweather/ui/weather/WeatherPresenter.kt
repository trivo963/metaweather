package com.example.trivo.metaweather.ui.weather

import com.example.trivo.metaweather.base.BasePresenter
import com.example.trivo.metaweather.model.ConsolidatedWeather
import com.example.trivo.metaweather.model.Weather
import com.example.trivo.metaweather.model.WeatherResponse
import com.example.trivo.metaweather.network.api.MetaWeatherApi
import com.example.trivo.metaweather.util.CITIES
import com.example.trivo.metaweather.util.DateUtil
import io.reactivex.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WeatherPresenter(weatherView: WeatherView) : BasePresenter<WeatherView>(weatherView) {

    @Inject
    lateinit var metaWeatherApi: MetaWeatherApi

    private var subscription: Disposable?= null

    override fun onViewCreated() {
        getWeather()
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }

    private fun getWeatherHelper():Single<List<Weather>> {
        return getCities()
                .flatMap { it -> metaWeatherApi.getLocation(it)}
                .flatMap { locations -> metaWeatherApi.getWeather(locations[0].woeid)}
                .flatMap { response: WeatherResponse -> Observable.just(mapWeather(response.title, response.consolidated_weather))  }
                .toList()
    }

    private fun getCities() : Observable<String> {
        return Observable.fromIterable(CITIES)
        // TODO - Consume cities from network or local storage
    }

    private fun mapWeather(city:String, weather: List<ConsolidatedWeather>) : Weather {
        val newWeather = weather.filter { it.applicable_date == DateUtil.getTomorrow() }
        return Weather(city, newWeather[0])
    }

    private fun getWeather() {
        view.showLoading(true)
        subscription = getWeatherHelper()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        { weatherList -> view.showWeather(weatherList); view.showLoading(false)},
                        { t->t.printStackTrace();view.showLoading(false);t?.message?.let { view.showError(it) } })
    }

}