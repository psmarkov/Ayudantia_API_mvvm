package com.example.ayudantiaexamen.Data.Repository

import com.example.ayudantiaexamen.Data.Network.Api.VideoGameServices
import com.example.ayudantiaexamen.Data.Response.VideoGameResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VideoGameImpl(private var apiservice:VideoGameServices) : VideoGameRepository {

    override suspend fun fetchVideoGames(): MutableList<VideoGameResponse> {
     // Implementar courutina que decide donde va a ir si a web o a bd interna
        // proceso pesados se usa suspend
    return withContext(Dispatchers.IO){
        val listVideoGames = apiservice.getAllVideoGames()
        listVideoGames
    }

    }


}