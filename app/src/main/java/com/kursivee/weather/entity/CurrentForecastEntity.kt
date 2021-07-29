package com.kursivee.weather.entity

import com.kursivee.weather.network.model.ForecastResponse
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

data class CurrentForecastEntity(
    val currentFahrenheit: Int,
    val maxFahrenheit: Int,
    val minFahrenheit: Int,
    val time: Long,
    val location: String,
    val feelsLikeFahrenheit: Int
) {

    fun timeString(): String {
        val date = Date(time * 1000)
        val formatter = SimpleDateFormat("MMMM dd, h:mm aa", Locale.ENGLISH)
        formatter.timeZone = TimeZone.getDefault()
        return formatter.format(date)
    }

    companion object {
        fun create(forecastResponse: ForecastResponse): CurrentForecastEntity {
            return CurrentForecastEntity(
                currentFahrenheit = forecastResponse.current.temp_f.toInt(),
                maxFahrenheit = forecastResponse.forecast.forecastday[0].day.maxtemp_f.toInt(),
                minFahrenheit = forecastResponse.forecast.forecastday[0].day.mintemp_f.toInt(),
                time = forecastResponse.location.localtime_epoch,
                location = "${forecastResponse.location.name}, ${forecastResponse.location.region}",
                feelsLikeFahrenheit = forecastResponse.current.feelslike_f.toInt()
            )
        }
    }
}
