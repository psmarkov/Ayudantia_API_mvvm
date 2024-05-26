package com.example.ayudantiaexamen.Presentation.View

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ayudantiaexamen.Data.Response.VideoGameResponse
import com.example.ayudantiaexamen.databinding.GameItemBinding
import com.squareup.picasso.Picasso

class VideoGameAdapter : RecyclerView.Adapter<VideoGameAdapter.ViewHolder>() {

    var videoGames = mutableListOf<VideoGameResponse>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            this.notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoGameAdapter.ViewHolder {
        val binding = GameItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoGameAdapter.ViewHolder, position: Int) {
        val videoGame = videoGames[position]
        holder.bindVideoGame(videoGame)

    }

    override fun getItemCount(): Int {
        return videoGames.size

    }

    inner class ViewHolder(private var binding: GameItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bindVideoGame(videoGame: VideoGameResponse) {

            binding.imgVideoGame.setImageResource(0)
            Picasso.get()
                .load(videoGame.backgroundImage)
                .centerCrop()
                .fit()
                .into(binding.imgVideoGame)

            binding.txtNameVideoGame.text = videoGame.name
            binding.txtReleasedVideoGame.text = videoGame.released
            binding.txtRatingVideoGame.text = videoGame.rating.toString()

        }
    }

}