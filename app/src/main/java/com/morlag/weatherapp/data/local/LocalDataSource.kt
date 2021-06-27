package com.morlag.weatherapp.data.local

import com.morlag.weatherapp.data.local.entities.City
import io.reactivex.rxjava3.core.Flowable
//import io.reactivex.rxjava3.core.Single

interface LocalDataSource {

    fun addCity(cities: List<City>)

    fun getCitiesByName(name: String) : Flowable<List<City>>

}