package com.morlag.weatherapp.data.local

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import org.json.JSONStringer
import java.lang.reflect.Type

class ResourceFetcher (val mContext: Context) {
    val TAG = "ResourceFetcher"
    val gson = GsonBuilder().create()

    fun getResourceString(resourceId: Int) : String {
        val text = mContext.resources
            .openRawResource(resourceId)
            .bufferedReader().use{ it.readText() }
        return text
    }
    /*
    fun <T:Any> getResourceArrayList(resourceId: Int) : ArrayList<T> {
        try {
            val l = gson.fromJson(getResourceString(resourceId), Class.forName(ArrayList<T>().javaClass.name))
            return l as ArrayList<T>;
        }
        catch (e: JsonSyntaxException){
            android.util.Log.d(TAG,"Resource fetching exception.", e)
        }
    }*/
}