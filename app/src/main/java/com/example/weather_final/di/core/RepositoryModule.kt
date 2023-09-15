package com.example.weather_final.di.core


import com.example.weather_final.data.datasource.WeatherDbDataSource
import com.example.weather_final.data.datasource.WeatherRemoteDataSource
import com.example.weather_final.data.implementation.repositoryImpl.WeatherRepositoryImpl
import com.example.weather_final.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideWeatherRepository(
        weatherRemoteDataSource: WeatherRemoteDataSource,
        weatherDbDataSource: WeatherDbDataSource,
    ): WeatherRepository {
        return WeatherRepositoryImpl(weatherRemoteDataSource, weatherDbDataSource)
    }
}