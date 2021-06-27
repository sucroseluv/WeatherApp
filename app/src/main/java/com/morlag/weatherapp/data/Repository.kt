package com.morlag.weatherapp.data

import com.morlag.weatherapp.data.dto.WeatherInfo
import com.morlag.weatherapp.data.local.LocalDataSource
import com.morlag.weatherapp.data.remote.RemoteDataSource
import io.reactivex.rxjava3.core.Single
import okhttp3.ResponseBody
import retrofit2.Response

class Repository
    constructor(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource)
    : RepositorySource {

    override fun requestWeather(lattitude: Double, longitude: Double): Single<WeatherInfo> {
        return remoteDataSource.requestWeather(lattitude, longitude)
    }

}