package com.kursivee.weather.ui.current

import com.kursivee.weather.entity.CurrentForecastEntity
import com.kursivee.weather.network.WeatherRepository
import com.kursivee.weather.util.AppResult

class GetCurrentForecast constructor(private val weatherRepository: WeatherRepository) {
    suspend operator fun invoke(zipCode: String): AppResult<CurrentForecastEntity> {
        return weatherRepository.getForecast(zipCode)
    }
}