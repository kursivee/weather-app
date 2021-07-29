package com.kursivee.weather.ui.current.di

import com.kursivee.weather.network.WeatherRepository
import com.kursivee.weather.ui.current.GetCurrentForecast
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object CurrentForecastModule {

    @Provides
    fun provideGetCurrentForecast(weatherRepository: WeatherRepository) = GetCurrentForecast(weatherRepository)
}
