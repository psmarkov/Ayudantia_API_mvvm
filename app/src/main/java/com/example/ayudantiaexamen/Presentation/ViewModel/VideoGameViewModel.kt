package com.example.ayudantiaexamen.Presentation.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ayudantiaexamen.Data.Response.VideoGameResponse
import com.example.ayudantiaexamen.Domain.VideoGameUseCase
import kotlinx.coroutines.launch

class VideoGameViewModel(private val useCase: VideoGameUseCase) : ViewModel() {
    private var videoGameList = MutableLiveData<MutableList<VideoGameResponse>>()

    val videoGameLv
        get() = videoGameList

    init {
        viewModelScope.launch {
            videoGameList.value = useCase.getAllVideoGamesOnStock()

        }

    }

}