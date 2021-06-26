package com.morlag.weatherapp.data.remote.service

import com.morlag.weatherapp.data.dto.WeatherInfo
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {

    @GET("data/2.5/onecall?exclude=minutely,daily,alerts,current&units=metric&lang=ru&appid=d5a033f41be5816664907c5af6463d33")
    fun fetchWeatherDepr(
        @Query("lat") lattitude: Double,
        @Query("lon") longitude: Double
        ) : Single<Response<ResponseBody>>

    @GET("data/2.5/onecall?exclude=minutely,daily,alerts,current&units=metric&lang=ru&appid=d5a033f41be5816664907c5af6463d33")
    fun fetchWeather(
        @Query("lat") lattitude: Double,
        @Query("lon") longitude: Double
    ) : Single<WeatherInfo>
}