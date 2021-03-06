package com.kursivee.weather.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Location(
    val country: String,
    val lat: Double,
    val localtime: String,
    val localtime_epoch: Long,
    val lon: Double,
    val name: String,
    val region: String,
    val tz_id: String
)
