package com.example.weather_final.di

import com.example.weather_final.di.weathermodule.WeatherSubComponent


interface Injector {

    fun createWeatherSubComponent(): WeatherSubComponent
}