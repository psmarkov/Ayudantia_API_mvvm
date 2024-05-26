package com.example.ayudantiaexamen.Presentation.View

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ayudantiaexamen.Data.Network.Api.VideoGameServices
import com.example.ayudantiaexamen.Data.Network.Retrofit.RetrofitHelper
import com.example.ayudantiaexamen.Data.Repository.VideoGameImpl
import com.example.ayudantiaexamen.Domain.VideoGameUseCase
import com.example.ayudantiaexamen.Presentation.ViewModel.VideoGameViewModel
import com.example.ayudantiaexamen.Presentation.ViewModel.ViewModelFactory
import com.example.ayudantiaexamen.R
import com.example.ayudantiaexamen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiservice = RetrofitHelper.getRetrofit().create(VideoGameServices::class.java)
        val repository = VideoGameImpl(apiservice)
        val useCase = VideoGameUseCase(repository)

        val viewModelFactory = ViewModelFactory(useCase)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(VideoGameViewModel::class.java)

        val adapterVideoGame = VideoGameAdapter()
        binding.vgRecycler.adapter = adapterVideoGame
        binding.vgRecycler.layoutManager = LinearLayoutManager(this)


        viewModel.videoGameLv.observe(this){

            //Log.i("GAMES", it.toString())

            adapterVideoGame.videoGames = it

        }



    }
}