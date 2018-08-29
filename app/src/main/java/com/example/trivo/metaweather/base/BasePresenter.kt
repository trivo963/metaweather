package com.example.trivo.metaweather.base

import com.example.trivo.metaweather.app.ContextModule
import com.example.trivo.metaweather.app.DaggerPresenterInjector
import com.example.trivo.metaweather.app.PresenterInjector
import com.example.trivo.metaweather.network.NetworkModule
import com.example.trivo.metaweather.ui.weather.WeatherPresenter

abstract class BasePresenter<out V : BaseView>(protected val view: V) {

    private val injector : PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    open fun onViewCreated() {}

    open fun onViewDestroyed() {}

    private fun inject() {
        when(this) {
            is WeatherPresenter -> injector.inject(this)
        }
    }

}