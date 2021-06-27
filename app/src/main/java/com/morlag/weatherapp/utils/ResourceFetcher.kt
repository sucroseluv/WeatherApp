package com.morlag.weatherapp.utils

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.morlag.weatherapp.R
import com.morlag.weatherapp.data.local.LocalDatabase
import com.morlag.weatherapp.data.local.entities.City

class ResourceFetcher (val mContext: Context) {
    val TAG = "ResourceFetcher"
    val gson = GsonBuilder().create()

    fun getResourceString(resourceId: Int) : String {
        val text = mContext.resources
            .openRawResource(resourceId)
            .bufferedReader().use{ it.readText() }
        return text
    }

    fun <T:Any> getResourceArrayList(resourceId: Int) : ArrayList<T> {
        try {
            val l = gson.fromJson(
                mContext.resources.openRawResource(resourceId).bufferedReader().use{ it.readText() },
                Class.forName(ArrayList<T>().javaClass.name))
            return l as ArrayList<T>
        }
        catch (e: JsonSyntaxException){
            android.util.Log.d(TAG,"Resource fetching exception.", e)
        }
        return arrayListOf()
    }

    fun fillCities(database: LocalDatabase){
        val citiesJson = getResourceArrayList<CityJson>(R.raw.cities)
        val cities = citiesJson.map{
            return@map City(
                it.id ?: 0,
                it.id ?: 0,
                it.name ?: "",
                it.country ?: "",
                it.coord?.lon ?: 0.0,
                it.coord?.lat ?: 0.0,
                it.zoom ?: 0,
                )
        }
        database.cityDao().addCities(cities)
    }

}