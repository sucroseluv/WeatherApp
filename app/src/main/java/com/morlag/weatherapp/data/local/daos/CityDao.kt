package com.morlag.weatherapp.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.morlag.weatherapp.data.local.entities.City
import io.reactivex.rxjava3.core.Flowable

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCities(cities: List<City>)

    @Query("SELECT * FROM city_table WHERE name like :name order by name")
    fun getCitiesByName(name: String) : Flowable<List<City>>
}