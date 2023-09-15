package com.example.weather_final.data.datasource

import com.example.weather_final.data.model.WeatherList
import retrofit2.Response

interface WeatherRemoteDataSource {

    suspend fun getWeatherDetailsRemoteForCity(city: String) :Response<WeatherList>?
}