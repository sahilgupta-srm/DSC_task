package com.example.weather_final.di.core


import com.example.weather_final.data.api.WeatherApiService
import com.example.weather_final.data.datasource.WeatherRemoteDataSource
import com.example.weather_final.data.implementation.dataSourceImpl.WeatherRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataSourceModule(
    private val apikey: String
) {
    @Singleton
    @Provides
    fun provideWeatherRemoteDataSource(weatherApiService: WeatherApiService): WeatherRemoteDataSource =
        WeatherRemoteDataSourceImpl(weatherApiService, apikey)
}