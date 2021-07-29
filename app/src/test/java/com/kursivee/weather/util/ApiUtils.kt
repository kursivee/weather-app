package com.kursivee.weather.util

import com.kursivee.weather.network.WeatherApi
import okhttp3.HttpUrl
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun createWeatherApi(baseUrl: HttpUrl): WeatherApi {
    return Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(baseUrl)
        .build()
        .create(WeatherApi::class.java)
}
