package com.example.weather_final.domain.usecase

import com.example.weather_final.domain.repository.WeatherRepository


class UpdateWeatherDetailsForCityUseCase(private val weatherRepository : WeatherRepository) {

    suspend fun execute() = weatherRepository.updateWeatherDetailsForDbCities()
}