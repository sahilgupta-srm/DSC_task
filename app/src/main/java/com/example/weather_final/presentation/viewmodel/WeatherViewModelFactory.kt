package com.example.weather_final.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weather_final.domain.usecase.GetAllWeatherDetailsUseCase
import com.example.weather_final.domain.usecase.GetWeatherDetailsForCityUseCase
import com.example.weather_final.domain.usecase.UpdateWeatherDetailsForCityUseCase


class WeatherViewModelFactory(
    private val getWeatherDetailsForCityUseCase: GetWeatherDetailsForCityUseCase,
    private val updateWeatherDetailsForCityUseCase: UpdateWeatherDetailsForCityUseCase,
    private val getAllWeatherDetailsUseCase: GetAllWeatherDetailsUseCase

) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeatherViewModel(
            getWeatherDetailsForCityUseCase,
            updateWeatherDetailsForCityUseCase,
            getAllWeatherDetailsUseCase
        ) as T
    }
}