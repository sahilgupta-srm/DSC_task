package com.example.weather_final.di.core

import com.example.weather_final.di.weathermodule.WeatherSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
    (
    modules = [
        AppModule::class,
        NetModule::class,
        DataBaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataSourceModule::class,
        DbDataSourceModule::class]
)
interface AppComponent {

    fun weatherSubComponent(): WeatherSubComponent.Factory

}