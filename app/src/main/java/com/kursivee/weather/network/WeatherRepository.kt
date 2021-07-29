package com.kursivee.weather.network

import arrow.core.Either
import com.kursivee.weather.entity.CurrentForecastEntity
import com.kursivee.weather.util.AppResult

class WeatherRepository constructor(private val weatherApi: WeatherApi) {
    suspend fun getForecast(zipCode: String): AppResult<CurrentForecastEntity> {
        val response = weatherApi.getForecast(zipCode)
        return if (response.isSuccessful) {
            Either.Right(CurrentForecastEntity.create(response.body() ?: return Either.Left(NullBody)))
        } else Either.Left(NetworkError(response.message(), response.code()))
    }
}
