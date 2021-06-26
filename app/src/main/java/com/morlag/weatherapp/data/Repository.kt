package com.morlag.weatherapp.data

import com.morlag.weatherapp.data.dto.WeatherInfo
import com.morlag.weatherapp.data.remote.RemoteDataSource
import io.reactivex.rxjava3.core.Single
import okhttp3.ResponseBody
import retrofit2.Response

class Repository
    constructor(val remoteDataSource: RemoteDataSource)
    : RepositorySource {

    override fun requestWeather(lattitude: Double, longitude: Double): Single<WeatherInfo> {
        return remoteDataSource.requestWeather(lattitude, longitude)
    }

}