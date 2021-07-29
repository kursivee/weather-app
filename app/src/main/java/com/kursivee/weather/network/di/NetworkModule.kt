package com.kursivee.weather.network.di

import com.kursivee.weather.BuildConfig
import com.kursivee.weather.network.WeatherApi
import com.kursivee.weather.network.WeatherRepository
import com.kursivee.weather.network.interceptor.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://api.weatherapi.com/"

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                val level = if (BuildConfig.DEBUG) {
                    (HttpLoggingInterceptor.Level.BODY)
                } else HttpLoggingInterceptor.Level.NONE
                setLevel(level)
            }
        )
        .addInterceptor(AuthInterceptor(BuildConfig.apikey))
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    fun provideWeatherApi(retrofit: Retrofit): WeatherApi = retrofit.create(WeatherApi::class.java)

    @Provides
    fun provideWeatherRepository(weatherApi: WeatherApi) = WeatherRepository(weatherApi)
}
