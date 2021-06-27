package com.morlag.weatherapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city_table")
data class City (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val idResource: Int,
    val name: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val zoom: Int
)
