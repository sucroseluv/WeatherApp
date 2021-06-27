package com.morlag.weatherapp.data.local

import com.morlag.weatherapp.data.local.entities.City
import io.reactivex.rxjava3.core.Flowable
//import io.reactivex.rxjava3.core.Single

class LocalData
    constructor(private val database: LocalDatabase)
    : LocalDataSource {

    override fun addCity(cities: List<City>) {
        database.cityDao().addCities(cities)
    }

    override fun getCitiesByName(name: String) : Flowable<List<City>>{
        return database.cityDao().getCitiesByName(name)
    }
}