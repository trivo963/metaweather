package com.example.trivo.metaweather.app

import android.app.Application
import android.content.Context
import com.example.trivo.metaweather.base.BaseView
import dagger.Module
import dagger.Provides

@Module
object ContextModule {

    @Provides
    @JvmStatic
    internal fun provideContext(baseView: BaseView) : Context {
        return baseView.getContext()
    }

    @Provides
    @JvmStatic
    internal fun provideAppContext(context: Context) : Application {
        return context.applicationContext as Application
    }

}