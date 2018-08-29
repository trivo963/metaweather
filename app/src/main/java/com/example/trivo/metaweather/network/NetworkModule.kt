package com.example.trivo.metaweather.network

import com.example.trivo.metaweather.BuildConfig
import com.example.trivo.metaweather.network.api.MetaWeatherApi
import com.example.trivo.metaweather.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideMetaWeatherApi(retrofit: Retrofit) : MetaWeatherApi {
        return retrofit.create(MetaWeatherApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitClient(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideInterceptor():  HttpLoggingInterceptor {
        return if(BuildConfig.DEBUG) {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
        } else {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
        }
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideOkHttp(interceptor:HttpLoggingInterceptor):OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

}