package com.example.movies

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_add_movie.*

class AddMovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)

        setSupportActionBar(toolbar.apply {
            title = "Add New Movie"
        })

        button.setOnClickListener {
            validateForm()
        }
    }

    private fun validateForm() {
        val title = title_editText.text.toString()
        val yearPublished = year_published_editText.text.toString().toIntOrNull()
        val description = description_editText.text.toString()

        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description) || yearPublished == null) {
            Snackbar.make(button, "Please fill out all fields", Snackbar.LENGTH_SHORT).show()
            return
        }

        ViewModelProviders.of(this).get(MovieViewModel::class.java).insertMovie(Movie().apply {
            this.title = title
            this.datePublished = yearPublished
            this.description = description
        })

        finish()
    }
}