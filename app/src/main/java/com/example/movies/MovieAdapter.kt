package com.example.movies

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    var movieList = emptyList<Movie>()
        set(value)
        {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    {
        return MovieItemViewHolder(parent)
    }

    override fun getItemCount(): Int
    {
        return movieList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)
    {
        (holder as MovieItemViewHolder).onBind(movieList[position])
    }
}