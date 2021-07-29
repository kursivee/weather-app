package com.kursivee.weather.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Forecastday(
    val astro: Astro,
    val date: String,
    val date_epoch: Int,
    val day: Day,
    val hour: List<Hour>
)