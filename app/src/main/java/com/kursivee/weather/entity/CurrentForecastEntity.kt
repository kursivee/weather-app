package com.kursivee.weather.entity

import com.kursivee.weather.network.model.ForecastResponse

data class CurrentForecastEntity(
    val currentFahrenheit: Double,
    val maxFahrenheit: Double,
    val minFahrenheit: Double,
    val time: Int,
    val location: String
) {
    companion object {
        fun create(forecastResponse: ForecastResponse): CurrentForecastEntity {
            return CurrentForecastEntity(
                currentFahrenheit = forecastResponse.current.temp_f,
                maxFahrenheit = forecastResponse.forecast.forecastday[0].day.maxtemp_f,
                minFahrenheit = forecastResponse.forecast.forecastday[0].day.mintemp_f,
                time = forecastResponse.location.localtime_epoch,
                location = "${forecastResponse.location.name}, ${forecastResponse.location.region}"
            )
        }
    }
}
