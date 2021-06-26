package com.morlag.weatherapp.data.remote

import com.morlag.weatherapp.data.dto.WeatherInfo
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import okhttp3.ResponseBody
import retrofit2.Response


interface RemoteDataSource {

    //fun requestWeather(lattitude: Double, longitude: Double) : Single<Response<ResponseBody>>
    fun requestWeather(lattitude: Double, longitude: Double) : Single<WeatherInfo>
}