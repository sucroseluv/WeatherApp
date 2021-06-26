package com.morlag.weatherapp.ui.city_weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CityWeatherViewModelFactory
    constructor(private val lat : Double, private val lon : Double)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(CityWeatherViewModel::class.java))
            CityWeatherViewModel(lat,lon) as T
        else
            throw IllegalArgumentException("ViewModel Not Found")
    }
}