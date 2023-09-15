package com.example.weather_final.data.implementation.dataSourceImpl


import com.example.weather_final.data.api.WeatherApiService
import com.example.weather_final.data.datasource.WeatherRemoteDataSource
import com.example.weather_final.data.model.WeatherList
import retrofit2.Response

class WeatherRemoteDataSourceImpl(val apiService: WeatherApiService, val appId : String) :
    WeatherRemoteDataSource {

    override suspend fun getWeatherDetailsRemoteForCity(city: String): Response<WeatherList> =
        apiService.getWeatherForCity(appId, city)

}