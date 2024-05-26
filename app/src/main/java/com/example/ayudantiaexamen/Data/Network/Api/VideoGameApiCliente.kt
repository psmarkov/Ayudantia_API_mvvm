package com.example.ayudantiaexamen.Data.Network.Api

import com.example.ayudantiaexamen.Data.Network.Retrofit.RetrofitHelper
import com.example.ayudantiaexamen.Data.Response.VideoGameResponse

class VideoGameApiCliente {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getVideoGames():MutableList<VideoGameResponse>{
        val response = retrofit.create(VideoGameServices::class.java).getAllVideoGames()
        return response

    }

}