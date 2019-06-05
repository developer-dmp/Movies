package com.example.movies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private val movieRepository = MovieRepository(MovieDatabase.getDatabase(application).getMovieDao())

    val movieListLiveData: LiveData<List<Movie>> by lazy {
        movieRepository.getAllMovies()
    }

    fun insertMovie(movie: Movie) = viewModelScope.launch(Dispatchers.IO) {
        movieRepository.insertMovie(movie)
    }

    fun deleteAllMovies() = viewModelScope.launch(Dispatchers.IO) {
        movieRepository.deleteAllMovies()
    }
}