package com.kursivee.weather.network

import com.kursivee.weather.network.model.ForecastResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/v1/forecast.json")
    suspend fun getForecast(@Query("q") zipCode: String): Response<ForecastResponse>
}
