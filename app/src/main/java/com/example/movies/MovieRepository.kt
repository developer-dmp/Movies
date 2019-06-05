package com.example.movies

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class MovieRepository(private val movieDao: MovieDao)
{
    fun getAllMovies(): LiveData<List<Movie>>
    {
        return movieDao.getAllMoviesLiveData()
    }

    @WorkerThread
    fun insertMovie(movie: Movie)
    {
        movieDao.insertMovie(movie)
    }

    @WorkerThread
    fun deleteAllMovies()
    {
        movieDao.deleteAllMovies()
    }
}