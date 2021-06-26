package com.morlag.weatherapp.data.remote

import com.morlag.weatherapp.data.dto.WeatherInfo
import com.morlag.weatherapp.data.remote.service.WeatherService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Response

class RemoteData : RemoteDataSource {

    var weatherService : WeatherService

    constructor(serviceProvider: ServiceProvider) {
        weatherService = serviceProvider.createService(WeatherService::class.java)
    }

    override fun requestWeather(lattitude: Double, longitude: Double): Single<WeatherInfo> {
        return weatherService.fetchWeather(lattitude, longitude)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


}