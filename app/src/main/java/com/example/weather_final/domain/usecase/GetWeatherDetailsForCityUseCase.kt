package com.example.weather_final.domain.usecase

import com.example.weather_final.data.model.WeatherList
import com.example.weather_final.domain.repository.WeatherRepository


class GetWeatherDetailsForCityUseCase(private val weatherRepository : WeatherRepository) {

    suspend fun execute(city : String): WeatherList? = weatherRepository.getWeatherDetailsForCity(city)
}