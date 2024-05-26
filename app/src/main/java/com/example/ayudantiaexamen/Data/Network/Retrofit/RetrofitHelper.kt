package com.example.ayudantiaexamen.Data.Network.Retrofit

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit () : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/himuravidal/gamesDB/games/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}