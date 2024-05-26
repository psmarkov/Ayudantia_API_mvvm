package com.example.ayudantiaexamen.Data.Network.Api

import com.example.ayudantiaexamen.Data.Response.VideoGameResponse
import retrofit2.http.GET

interface VideoGameServices {

    @GET ("games")
    suspend fun  getAllVideoGames() : MutableList<VideoGameResponse>


}