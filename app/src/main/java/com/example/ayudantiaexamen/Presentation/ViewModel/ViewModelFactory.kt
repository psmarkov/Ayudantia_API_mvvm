package com.example.ayudantiaexamen.Presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ayudantiaexamen.Domain.VideoGameUseCase
import java.lang.IllegalArgumentException

class ViewModelFactory(private val videoGamesUseCase: VideoGameUseCase):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VideoGameViewModel::class.java)){
            return VideoGameViewModel(videoGamesUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}