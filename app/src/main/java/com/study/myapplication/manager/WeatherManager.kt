package com.study.myapplication.manager

import com.study.myapplication.api.WeatherApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherManager {
    private val weatherApi: WeatherApi
    val api: WeatherApi
        get() = weatherApi

    companion object {
        val instance = WeatherManager()
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://opendata.cwb.gov.tw/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        weatherApi = retrofit.create(WeatherApi::class.java)
    }

}