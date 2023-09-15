package com.example.weather_final.domain.repository

import androidx.lifecycle.LiveData
import com.example.weather_final.data.model.WeatherList

interface WeatherRepository {

    suspend fun getWeatherDetailsForCity(city: String): WeatherList?
    suspend fun updateWeatherDetailsForDbCities()
    fun getAllWeatherDetails(): LiveData<List<WeatherList>>
}