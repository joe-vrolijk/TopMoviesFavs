package nl.joevrolijk.topmoviesfavs.ui.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_details.*
import nl.joevrolijk.topmoviesfavs.R
import nl.joevrolijk.topmoviesfavs.model.Movie
import nl.joevrolijk.topmoviesfavs.ui.search.SearchMovie
import nl.joevrolijk.topmoviesfavs.viewmodel.MovieDetailsViewModel

class MovieDetails : AppCompatActivity() {

    private lateinit var movieDetailsViewModel: MovieDetailsViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        initViews()
        initViewModel()
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


        info_btn_add.setOnClickListener{
            addMovieToList()
        }
    }

    private fun initViewModel(){
        this.movieDetailsViewModel = ViewModelProviders.of(this).get(MovieDetailsViewModel::class.java)
    }



    private fun addMovieToList(){
        val movie = intent.getParcelableExtra<Movie>(SearchMovie.EXTRA_MOVIE)
        var userRating = info_input_rating.text.toString()

        if (userRating.isNotBlank()){
            movie.userRating = userRating.toDouble()
            movieDetailsViewModel.insertMovie(movie)

            val resultIntent = Intent()
            resultIntent.putExtra(MOVIE_JOE, movie)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()

        } else {
            Toast.makeText(this, "Please enter a user rating between 1 and 10", Toast.LENGTH_SHORT).show()
        }

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

    companion object {
        const val MOVIE_JOE = "MOVIE_JOE"
    }


}

