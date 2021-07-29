package com.kursivee.weather.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Forecast(
    val forecastday: List<Forecastday>
)