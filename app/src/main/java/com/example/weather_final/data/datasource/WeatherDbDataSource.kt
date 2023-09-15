package com.example.weather_final.data.datasource

import androidx.lifecycle.LiveData
import com.example.weather_final.data.model.WeatherList


interface WeatherDbDataSource {
    suspend fun getWeatherDetailsDbForCity(city :String) : WeatherList
    suspend fun saveWeatherDetailsDbForCity(weatherList : WeatherList)
    suspend fun clearAllWeatherList()
    fun getAllWeatherList(): LiveData<List<WeatherList>>
}