package nl.joevrolijk.topmoviesfavs.ui.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_details.*
import nl.joevrolijk.topmoviesfavs.R
import nl.joevrolijk.topmoviesfavs.model.Movie
import nl.joevrolijk.topmoviesfavs.ui.search.SearchMovie

class MovieDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        initViews()
    }

    private fun initViews() {
        val movie = intent.getParcelableExtra<Movie>(SearchMovie.EXTRA_MOVIE)

        if (!movie.getBackdropImageUrl().isNullOrEmpty()) {
            Glide.with(this).load(movie.getBackdropImageUrl()).into(info_backdrop)
        }

        if (movie.releaseDate.length > 4) {
            info_title.text = movie.title + " (" + movie.releaseDate.substring(0, 4) + ")"
        } else {
            info_title.text = movie.title
        }

        info_public_rating.text = "Rating: " + movie.voteAverage
        info_overview.text = movie.overview
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

