package com.example.fetch.api

import com.example.fetch.model.FetchDataItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("hiring.json")
    fun getReward():Call<List<FetchDataItem>>

    companion object {
        var baseUrl = "https://fetch-hiring.s3.amazonaws.com/"

        fun create() : ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }
}