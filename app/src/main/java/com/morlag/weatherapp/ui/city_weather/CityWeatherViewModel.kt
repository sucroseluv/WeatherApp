package com.morlag.weatherapp.ui.city_weather

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.morlag.weatherapp.data.dto.WeatherInfo
import com.morlag.weatherapp.di.Injection
import io.reactivex.rxjava3.internal.util.HalfSerializer.onNext

class CityWeatherViewModel
    constructor(
        val lattitude: Double,
        val longitude: Double
    )
    : ViewModel() {
    val repository = Injection.repository
    var data : WeatherInfo? = null
    val weatherInfo : MutableLiveData<WeatherInfo> = MutableLiveData<WeatherInfo>().apply { value = data }
    val error : MutableLiveData<String?> = MutableLiveData<String?>().apply { value = null }

    //val temp : MutableLiveData<String?> = MutableLiveData<String?>().apply { value = null }

    init {
        requestWeather()


    }

    private fun requestWeather(){
        repository!!.requestWeather(lattitude,longitude)
            .subscribe({
                //temp.value = if (it.isSuccessful) it.body()?.string() else it.errorBody()?.string()
                /*Log.d("City",temp.value ?: "null value" )

                data = Gson().fromJson(temp.value,WeatherInfo::class.java)
                weatherInfo.value = data
                */

                /*if(it.isSuccessful){
                    data = Gson().fromJson(it.body()?.string(),WeatherInfo::class.java)
                    weatherInfo.value = data
                }*/
                data = it
                weatherInfo.value = data
            },{
                error.value = "Ошибка получения данных."
            })
    }




}