package com.morlag.weatherapp.utils

class CityJson {
    var id: Int? = null
    var name: String? = null
    var country: String? = null
    var coord: Coordinate? = null
    var zoom: Int? = null
}
class Coordinate {
    var lat: Double? = null
    var lon: Double? = null
}