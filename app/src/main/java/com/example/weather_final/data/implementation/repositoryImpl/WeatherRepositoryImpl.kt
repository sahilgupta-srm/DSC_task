package com.example.weather_final.data.implementation.repositoryImpl

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.weather_final.data.datasource.WeatherDbDataSource
import com.example.weather_final.data.datasource.WeatherRemoteDataSource
import com.example.weather_final.data.model.WeatherList
import com.example.weather_final.domain.repository.WeatherRepository

import retrofit2.Response
import java.lang.Exception

class WeatherRepositoryImpl(
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
    private val weatherDbDataSource: WeatherDbDataSource,
) : WeatherRepository {


    override suspend fun getWeatherDetailsForCity(city: String): WeatherList? {
        var weatherList: WeatherList? = getWeatherDetailsForCityFromDb(city)
        if (weatherList != null)
            return weatherList
        weatherList = getWeatherDetailsForCityFromApi(city)
        if (weatherList != null)
            saveWeatherDetailsForDbCities(weatherList)
        return weatherList
    }


    override suspend fun updateWeatherDetailsForDbCities() {

    }

    suspend fun saveWeatherDetailsForDbCities(weatherList: WeatherList) {
        Log.e("Repository", "savedbAll")
        weatherDbDataSource.saveWeatherDetailsDbForCity(weatherList)
    }


    override fun getAllWeatherDetails(): LiveData<List<WeatherList>> {
        Log.e("Repository", weatherDbDataSource.getAllWeatherList().toString())
        return weatherDbDataSource.getAllWeatherList()
    }


    private suspend fun getWeatherDetailsForCityFromApi(city: String): WeatherList? {
        var weatherList: WeatherList? = null
        try {
            val response: Response<WeatherList>? =
                weatherRemoteDataSource.getWeatherDetailsRemoteForCity(city)
            val body: WeatherList? = response?.body()
            Log.e("Repository", "rm")

            if (body != null) {
                weatherList = body
            }

        } catch (e: Exception) {
            Log.e("Repository", e.localizedMessage.toString())
        }
        return weatherList
    }

    private suspend fun getWeatherDetailsForCityFromDb(city: String): WeatherList? {
        var weatherList: WeatherList? = null
        try {
            weatherList = weatherDbDataSource.getWeatherDetailsDbForCity(city)
            Log.e("Repository", "db")

        } catch (e: Exception) {
            Log.e("Repository", e.localizedMessage.toString())
        }
        return weatherList
    }

}