package com.kursivee.weather.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConditionX(
    val code: Int,
    val icon: String,
    val text: String
)
