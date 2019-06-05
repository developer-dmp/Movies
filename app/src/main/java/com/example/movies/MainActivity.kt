package com.example.movies

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        movieAdapter = MovieAdapter()

        setSupportActionBar(toolbar.apply {
            title = getString(R.string.app_name)
        })

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = movieAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        movieViewModel.movieListLiveData.observe(this, Observer { movieList ->
            movieAdapter.movieList = movieList
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.add_movie -> {
                onAddMovie()
                true
            }

            R.id.delete_all_movies -> {
                onDeleteAllMovies()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun onAddMovie() {
        startActivity(Intent(this, AddMovieActivity::class.java))
    }

    private fun onDeleteAllMovies() {
        movieViewModel.deleteAllMovies()
    }
}
