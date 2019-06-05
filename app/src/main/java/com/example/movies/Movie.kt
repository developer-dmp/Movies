package com.example.movies

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
class Movie
{
    @PrimaryKey
    var title: String = ""

    var datePublished: Int = 0

    var description: String = ""
}