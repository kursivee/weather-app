package com.kursivee.weather.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Astro(
    val moon_illumination: String,
    val moon_phase: String,
    val moonrise: String,
    val moonset: String,
    val sunrise: String,
    val sunset: String
)