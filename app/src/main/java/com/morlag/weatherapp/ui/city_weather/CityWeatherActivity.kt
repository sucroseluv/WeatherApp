package com.morlag.weatherapp.ui.city_weather

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.morlag.weatherapp.R
import com.morlag.weatherapp.data.dto.WeatherInfo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_city_weather.*
import java.util.concurrent.Callable

class CityWeatherActivity : AppCompatActivity() {

    private val viewModel : CityWeatherViewModel by viewModels(factoryProducer = {
        CityWeatherViewModelFactory(
            intent.getDoubleExtra("lat",0.0),
            intent.getDoubleExtra("lon",0.0))
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_weather)

        initObservers()
    }

    fun initObservers(){
        viewModel.weatherInfo.observe(this, {
            //name.text = it?.timezone ?: "null"
            name.setText(it?.timezone ?: "null")
        })
        viewModel.error.observe(this,{
            it?.apply {
                Toast.makeText(this@CityWeatherActivity, it, Toast.LENGTH_SHORT).show()
                viewModel.error.value = null
            }
        })
    }
}