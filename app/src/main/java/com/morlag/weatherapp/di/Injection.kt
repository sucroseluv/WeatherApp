package com.morlag.weatherapp.di

import android.content.Context
import com.morlag.weatherapp.data.Repository
import com.morlag.weatherapp.data.RepositorySource
import com.morlag.weatherapp.data.local.LocalData
import com.morlag.weatherapp.data.local.LocalDataSource
import com.morlag.weatherapp.data.local.LocalDatabase
import com.morlag.weatherapp.data.remote.RemoteData
import com.morlag.weatherapp.data.remote.ServiceProvider

object Injection {

    private val serviceProvider = ServiceProvider()
    private val remoteDataSource = RemoteData(serviceProvider)
    private var database: LocalDatabase? = null
    private var localDataSource: LocalDataSource? = null

    var repository: RepositorySource? = null

    fun setAppContext(context: Context) {
        database = LocalDatabase.getDatabase(context)
        localDataSource = LocalData(database!!)
        repository = Repository(remoteDataSource, localDataSource!!)
    }
}