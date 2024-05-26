package com.example.ayudantiaexamen.Domain

import com.example.ayudantiaexamen.Data.Repository.VideoGameImpl
import com.example.ayudantiaexamen.Data.Repository.VideoGameRepository
import com.example.ayudantiaexamen.Data.Response.VideoGameResponse

class VideoGameUseCase(private val repository: VideoGameImpl) {

    suspend fun getAllVideoGamesOnStock(): MutableList<VideoGameResponse> {
        return repository.fetchVideoGames()

    }


}