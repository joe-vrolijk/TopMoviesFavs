package nl.joevrolijk.topmoviesfavs.ui.detail

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_edit_movie_details.*
import kotlinx.android.synthetic.main.activity_movie_details.*
import nl.joevrolijk.topmoviesfavs.R
import nl.joevrolijk.topmoviesfavs.model.Movie
import nl.joevrolijk.topmoviesfavs.ui.edit.EditActivity
import nl.joevrolijk.topmoviesfavs.ui.main.ADD_MOVIE_REQUEST_CODE
import nl.joevrolijk.topmoviesfavs.ui.main.MainActivity
import nl.joevrolijk.topmoviesfavs.ui.search.SearchMovie
import nl.joevrolijk.topmoviesfavs.ui.toplist.TopListActivity
import nl.joevrolijk.topmoviesfavs.viewmodel.EditViewModel
import nl.joevrolijk.topmoviesfavs.viewmodel.MovieDetailsViewModel

class EditMovieDetails : AppCompatActivity() {

    private lateinit var editViewModel: EditViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_movie_details)
        supportActionBar?.title = "Edit movie rating"
        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(true)

        initViews()
        initViewModel()
    }

    private fun initViews() {
        val movie = intent.getParcelableExtra<Movie>(EditActivity.EDIT_MOVIE)
        edit_input_rating.setText(movie.userRating.toString())

        if (!movie.getBackdropImageUrl().isNullOrEmpty()) {
            Glide.with(this).load(movie.getBackdropImageUrl()).into(edit_backdrop)
        }

        if (movie.releaseDate.length > 4) {
            edit_title.text = movie.title + " (" + movie.releaseDate.substring(0, 4) + ")"
        } else {
            edit_title.text = movie.title
        }

        edit_public_rating.text = "Rating: " + movie.voteAverage
        edit_overview.text = movie.overview

        edit_btn_add.setOnClickListener{
            updateRating(movie)
        }

        edit_btn_cancel.setOnClickListener{
            backToHome()
        }
    }

    private fun updateRating(movie: Movie){
        var userRating = edit_input_rating.text.toString()

        if (userRating.isNotBlank()){
            movie.userRating = userRating.toDouble()
            editViewModel.updateMovie(movie)

            val intent = Intent(this, TopListActivity::class.java)
            startActivity(intent)
//
//            val resultIntent = Intent(this, TopListActivity::class.java)
//            resultIntent.putExtra(MovieDetails.MOVIE_JOE, movie)
//            setResult(Activity.RESULT_OK, resultIntent)
//            finish()

        } else {
            Toast.makeText(this, "Please enter a user rating between 1 and 10", Toast.LENGTH_SHORT).show()
        }
    }

    private fun backToHome(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun initViewModel(){
        this.editViewModel = ViewModelProviders.of(this).get(EditViewModel::class.java)
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
        const val MOVIE_JOE2 = "MOVIE_JOE2"
    }


}
