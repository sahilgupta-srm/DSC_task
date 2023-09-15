package com.example.weather_final.di.core


import com.example.weather_final.data.datasource.WeatherDbDataSource
import com.example.weather_final.data.db.WeatherDao
import com.example.weather_final.data.implementation.dataSourceImpl.WeatherDbDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbDataSourceModule {

    @Singleton
    @Provides
    fun provideWeatherDbDataSource(weatherDao: WeatherDao): WeatherDbDataSource = WeatherDbDataSourceImpl(weatherDao)

}