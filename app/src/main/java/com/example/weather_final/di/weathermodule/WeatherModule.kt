package com.example.weather_final.di.weathermodule


import com.example.weather_final.domain.usecase.GetAllWeatherDetailsUseCase
import com.example.weather_final.domain.usecase.GetWeatherDetailsForCityUseCase
import com.example.weather_final.domain.usecase.UpdateWeatherDetailsForCityUseCase
import com.example.weather_final.presentation.viewmodel.WeatherViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class WeatherModule {

    @WeatherScope
    @Provides
    fun provideWeatherViewModelFactory(
        getWeatherDetailsForCityUseCase: GetWeatherDetailsForCityUseCase,
        updateWeatherDetailsForCityUseCase: UpdateWeatherDetailsForCityUseCase,
        getAllWeatherDetailsUseCase: GetAllWeatherDetailsUseCase
    ): WeatherViewModelFactory {
        return WeatherViewModelFactory(
            getWeatherDetailsForCityUseCase,
            updateWeatherDetailsForCityUseCase,
            getAllWeatherDetailsUseCase
        )
    }
}