package com.morlag.weatherapp.data.remote

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

class ServiceProvider {
    private var okhttp: OkHttpClient
    private var retrofit: Retrofit

    init {
        okhttp = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { this.level = HttpLoggingInterceptor.Level.BODY })
            /*.addInterceptor(Interceptor { chain ->
                val response = chain.proceed(chain.request())
                Log.w("Retrofit@Response", response.body!!.string())
                chain
            })*/
            .connectTimeout(30, TimeUnit.SECONDS) //Backend is really slow
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()


        retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttp)
            .build()
    }

    public fun <S> createService(service: Class<S>) : S {
        return retrofit.create(service)
    }
}