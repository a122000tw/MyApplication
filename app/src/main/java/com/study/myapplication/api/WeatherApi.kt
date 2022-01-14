package com.study.myapplication.api

import com.study.myapplication.model.WeatherInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/rest/datastore/F-C0032-001")
    fun getWeather(
        @Query("Authorization") key: String
    ): Call<List<WeatherInfo>>

}