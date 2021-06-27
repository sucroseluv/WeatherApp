package com.morlag.weatherapp.di

import android.app.Application

class ApplicationDi : Application() {

    init {
        Injection.setAppContext(this)
    }
}