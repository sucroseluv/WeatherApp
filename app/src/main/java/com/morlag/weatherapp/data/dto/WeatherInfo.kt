package com.morlag.weatherapp.data.dto

import com.google.gson.annotations.SerializedName

data class WeatherInfo(
    @SerializedName("lat")
    var lat: Double?,
    @SerializedName("lon")
    var lon: Double?,
    @SerializedName("timezone")
    var timezone: String?,
    @SerializedName("timezone_offset")
    var timezone_offset: Int?,
    @SerializedName("hourly")
    var weatherList: List<WeatherPart>
)
