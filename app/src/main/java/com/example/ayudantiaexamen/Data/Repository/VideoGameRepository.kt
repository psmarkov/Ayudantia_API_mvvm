package com.example.ayudantiaexamen.Data.Repository

import com.example.ayudantiaexamen.Data.Response.VideoGameResponse

interface VideoGameRepository {

   suspend fun fetchVideoGames() : MutableList<VideoGameResponse>



}