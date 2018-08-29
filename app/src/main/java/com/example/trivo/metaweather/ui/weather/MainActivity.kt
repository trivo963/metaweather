package com.example.trivo.metaweather.ui.weather

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.trivo.metaweather.R
import com.example.trivo.metaweather.base.BaseActivity
import com.example.trivo.metaweather.databinding.ActivityMainBinding
import com.example.trivo.metaweather.model.Weather

class MainActivity : BaseActivity<WeatherPresenter>(), WeatherView {

    private lateinit var binding: ActivityMainBinding
    private val weatherAdapter:WeatherAdapter = WeatherAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.adapter = weatherAdapter
        binding.layoutManager = LinearLayoutManager(this)

        presenter.onViewCreated()
    }

    override fun showWeather(weather: List<Weather>) {
        weatherAdapter.updateWeatherItems(weather)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading(isVisible: Boolean) {
        if(isVisible) {
            binding.progressVisibility = View.VISIBLE
        } else {
            binding.progressVisibility = View.GONE
        }
    }

    override fun initPresenter(): WeatherPresenter {
        return WeatherPresenter(this)
    }
}
