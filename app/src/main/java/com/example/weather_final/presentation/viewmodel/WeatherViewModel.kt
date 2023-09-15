package com.example.weather_final.presentation.viewmodel

import androidx.lifecycle.*
import com.example.weather_final.data.model.WeatherList
import com.example.weather_final.domain.usecase.GetAllWeatherDetailsUseCase
import com.example.weather_final.domain.usecase.GetWeatherDetailsForCityUseCase
import com.example.weather_final.domain.usecase.UpdateWeatherDetailsForCityUseCase
import kotlinx.coroutines.launch


class WeatherViewModel(
    private val getWeatherDetailsForCityUseCase: GetWeatherDetailsForCityUseCase,
    private val updateWeatherDetailsForCityUseCase: UpdateWeatherDetailsForCityUseCase,
    private val getAllWeatherDetailsUseCase: GetAllWeatherDetailsUseCase
) : ViewModel() {

    private val _city = MutableLiveData<WeatherList>()
    val city: LiveData<WeatherList>
        get() = _city

    fun fetchCity(cityStr: String): LiveData<WeatherList> {
        viewModelScope.launch {
            _city.value = getWeatherDetailsForCityUseCase.execute(cityStr)
        }
        return city
    }

    fun getAllWeatherDetails(): LiveData<List<WeatherList>> = getAllWeatherDetailsUseCase.execute()
    fun setSuggestion(list: List<WeatherList>): List<String> {
        return list.distinct().map { it.name }
    }

}




