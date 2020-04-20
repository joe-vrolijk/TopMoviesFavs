package nl.joevrolijk.topmoviesfavs.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import nl.joevrolijk.topmoviesfavs.R

class MovieDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        initViews()
    }

    private fun initViews() {

    }
}
