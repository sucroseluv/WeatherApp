package com.morlag.weatherapp.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    val searchText = MutableLiveData<String>().apply { "" }

}