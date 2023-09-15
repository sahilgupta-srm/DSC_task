package com.example.weather_final.domain.usecase

import androidx.lifecycle.LiveData
import com.example.weather_final.data.model.WeatherList
import com.example.weather_final.domain.repository.WeatherRepository


class GetAllWeatherDetailsUseCase(private val weatherRepository : WeatherRepository) {

    fun execute(): LiveData<List<WeatherList>> = weatherRepository.getAllWeatherDetails()
}