package com.morlag.weatherapp.data.dto

import com.google.gson.annotations.SerializedName

data class WeatherPart (
    var dt : Int? = null,
    var temp : Double? = null,
    var feels_like : Double? = null,
    var pressure : Int? = null,
    var humidity : Int? = null,
    var dew_point : Double? = null,
    var uvi : Double? = null,
    var clouds : Int? = null,
    var visibility : Int? = null,
    var wind_speed : Double? = null,
    var wind_deg : Double? = null,
    var wind_gust : Double? = null,
    var weather: List<Sky>? = null,
    var pop : Double? = null,
)