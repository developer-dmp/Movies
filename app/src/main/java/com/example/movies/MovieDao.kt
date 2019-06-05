package com.example.movies

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao
{
    @Insert
    fun insertMovie(movie: Movie)

    @Query("DELETE FROM movie_table")
    fun deleteAllMovies()

    @Query("SELECT * from movie_table ORDER BY title ASC")
    fun getAllMoviesLiveData(): LiveData<List<Movie>>
}