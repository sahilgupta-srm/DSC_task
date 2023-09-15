package com.example.weather_final.data.implementation.dataSourceImpl

import androidx.lifecycle.LiveData
import com.example.weather_final.data.datasource.WeatherDbDataSource
import com.example.weather_final.data.db.WeatherDao
import com.example.weather_final.data.model.WeatherList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherDbDataSourceImpl(val weatherDao: WeatherDao) : WeatherDbDataSource {

    override suspend fun getWeatherDetailsDbForCity(city: String): WeatherList = weatherDao.getWeatherDetailsForCity(city)

    override suspend fun saveWeatherDetailsDbForCity(weatherList: WeatherList) {
        CoroutineScope(Dispatchers.IO).launch { weatherDao.saveWeatherDetails(weatherList) }
    }

    override suspend fun clearAllWeatherList() {
        CoroutineScope(Dispatchers.IO).launch {
            weatherDao.deleteAllWeatherDetails()
        }
    }

    override fun getAllWeatherList(): LiveData<List<WeatherList>> =
        weatherDao.getAllWeatherDetails()
}