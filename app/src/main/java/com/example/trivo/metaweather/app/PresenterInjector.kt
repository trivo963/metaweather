package com.example.trivo.metaweather.app

import com.example.trivo.metaweather.base.BaseView
import com.example.trivo.metaweather.network.NetworkModule
import com.example.trivo.metaweather.ui.weather.WeatherPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {

    fun inject(weatherPresenter: WeatherPresenter)

    @Component.Builder
    interface Builder {
        fun build() : PresenterInjector

        fun networkModule(networModule: NetworkModule) : Builder
        fun contextModule(contextModule: ContextModule) : Builder

        @BindsInstance
        fun baseView(baseView: BaseView) : Builder
    }
}