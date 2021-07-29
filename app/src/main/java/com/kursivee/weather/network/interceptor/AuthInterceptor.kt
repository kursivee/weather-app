package com.kursivee.weather.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().run {
            val newUrl = url.newBuilder()
                .addQueryParameter("key", apiKey)
                .build()
            newBuilder()
                .url(newUrl)
                .build()
        }
        return chain.proceed(request)
    }
}
