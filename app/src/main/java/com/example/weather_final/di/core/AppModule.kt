package com.example.weather_final.di.core

import android.content.Context
import com.example.weather_final.di.weathermodule.WeatherSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [WeatherSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context { return context.applicationContext}
}