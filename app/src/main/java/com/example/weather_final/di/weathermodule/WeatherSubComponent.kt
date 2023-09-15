package com.example.weather_final.di.weathermodule


import com.example.weather_final.presentation.activtiy.HomeActivity
import com.example.weather_final.presentation.fragment.HomeFragment
import dagger.Subcomponent

@WeatherScope
@Subcomponent(modules = [WeatherModule::class])
interface WeatherSubComponent {

    fun inject(homeActivity: HomeActivity)

    fun inject(homeFragment: HomeFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create (): WeatherSubComponent
    }
}