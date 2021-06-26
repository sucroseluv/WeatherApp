package com.morlag.weatherapp.di

import com.morlag.weatherapp.data.Repository
import com.morlag.weatherapp.data.remote.RemoteData
import com.morlag.weatherapp.data.remote.ServiceProvider

object Injection {

    val serviceProvider = ServiceProvider()
    val remoteDataSource = RemoteData(serviceProvider)
    val repository = Repository(remoteDataSource)


}