package com.morlag.weatherapp.ui.search

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Gravity
import android.view.View.*
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import com.morlag.weatherapp.R
import com.morlag.weatherapp.ui.city_weather.CityWeatherActivity
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    //val viewModel: SearchViewModel = ViewModelLazy(SearchViewModel::class,{viewModelStore},{defaultViewModelProviderFactory}).value
    val viewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchField.addTextChangedListener(searchWatcher)
        toolbar.setOnClickListener {
            val i = Intent(this, CityWeatherActivity::class.java)
            i.putExtra("lat",55.0)
            i.putExtra("lon",73.4)
            startActivity(i)
        }
        initObservers()
    }

    private fun initObservers() {
        viewModel.searchText.observe(this,{
            setCancelVisible(it.isNotEmpty())
            setBigToolbar(it.isNotEmpty())
        })
    }

    private fun setCancelVisible(visible: Boolean) {cancelButton.visibility = if (visible) VISIBLE else GONE}

    private fun setBigToolbar(isBig: Boolean) {
        if(!isBig)
            toolbar.gravity = (Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL)
        else
            toolbar.gravity = (Gravity.BOTTOM or Gravity.LEFT)
    }

    val searchWatcher: TextWatcher = object: TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            Log.d("Search", "setted: " + s.toString())
            viewModel.searchText.value = s.toString()
        }
        override fun afterTextChanged(s: Editable?) { }
    }

}