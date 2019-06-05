package com.example.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieItemViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie_row, parent, false))
{
    private val titleTextView: TextView = itemView.findViewById(R.id.title_textView)
    private val publishedYearTextView: TextView = itemView.findViewById(R.id.year_published_textView)
    private val descriptionTextView: TextView = itemView.findViewById(R.id.description_textView)

    fun onBind(movie: Movie)
    {
        titleTextView.text = movie.title
        publishedYearTextView.text = movie.datePublished.toString()
        descriptionTextView.text = movie.description

        itemView.setOnClickListener {

        }
    }
}