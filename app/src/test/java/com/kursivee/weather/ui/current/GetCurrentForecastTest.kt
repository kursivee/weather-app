package com.kursivee.weather.ui.current

import com.kursivee.weather.entity.CurrentForecastEntity
import com.kursivee.weather.network.WeatherRepository
import com.kursivee.weather.util.createWeatherApi
import com.kursivee.weather.util.enqueueResponse
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetCurrentForecastTest {

    private lateinit var sut: GetCurrentForecast
    private val server = MockWebServer()

    @Before
    fun setup() {
        sut = GetCurrentForecast(WeatherRepository(createWeatherApi(server.url("/"))))
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun `when getting current forecast and response is successful return response`() {
        server.enqueueResponse("ForecastResponse.json", 200)
        runBlocking {
            val response = sut("12345")
            val expected = CurrentForecastEntity(
                currentFahrenheit = 73,
                maxFahrenheit = 95,
                minFahrenheit = 75,
                time = 1627520632,
                location = "Name, Region",
                feelsLikeFahrenheit = 76
            )
            assertEquals(expected, response.orNull())
        }
    }
}
