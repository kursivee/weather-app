package com.kursivee.weather.network

sealed interface ApplicationError
data class NetworkError(val error: String, val code: Int): ApplicationError
object NullBody : ApplicationError