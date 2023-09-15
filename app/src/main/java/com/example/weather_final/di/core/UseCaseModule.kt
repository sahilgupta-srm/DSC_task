package com.example.weather_final.di.core


import com.example.weather_final.domain.repository.WeatherRepository
import com.example.weather_final.domain.usecase.GetAllWeatherDetailsUseCase
import com.example.weather_final.domain.usecase.GetWeatherDetailsForCityUseCase
import com.example.weather_final.domain.usecase.UpdateWeatherDetailsForCityUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetWeatherDetailsForCityUseCase(weatherRepository: WeatherRepository): GetWeatherDetailsForCityUseCase {
        return GetWeatherDetailsForCityUseCase(weatherRepository)
    }
    @Provides
    fun provideUpdateWeatherDetailsForCityUseCase(weatherRepository: WeatherRepository): UpdateWeatherDetailsForCityUseCase {
        return UpdateWeatherDetailsForCityUseCase(weatherRepository)
    }

    @Provides
    fun provideGetAllWeatherDetailsUseCase(weatherRepository: WeatherRepository): GetAllWeatherDetailsUseCase {
        return GetAllWeatherDetailsUseCase(weatherRepository)
    }
}