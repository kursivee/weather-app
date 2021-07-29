package com.kursivee.weather.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForecastResponse(
    @field:Json(name = "current") val current: Current,
    @field:Json(name = "forecast") val forecast: Forecast,
    @field:Json(name = "location") val location: Location
)
