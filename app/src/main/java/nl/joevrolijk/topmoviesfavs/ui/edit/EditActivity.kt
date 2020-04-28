package nl.joevrolijk.topmoviesfavs.ui.edit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_delete.*
import kotlinx.android.synthetic.main.activity_edit.*
import nl.joevrolijk.topmoviesfavs.R
import nl.joevrolijk.topmoviesfavs.model.Movie
import nl.joevrolijk.topmoviesfavs.ui.delete.DeleteAdapter
import nl.joevrolijk.topmoviesfavs.ui.detail.EditMovieDetails
import nl.joevrolijk.topmoviesfavs.ui.detail.MovieDetails
import nl.joevrolijk.topmoviesfavs.ui.search.SearchMovie.Companion.EXTRA_MOVIE
import nl.joevrolijk.topmoviesfavs.viewmodel.DeleteViewModel
import nl.joevrolijk.topmoviesfavs.viewmodel.EditViewModel

class EditActivity : AppCompatActivity() {

    private val movies = arrayListOf<Movie>()
    private val editAdapter = EditAdapter(movies, {movie -> onMovieClick(movie)} )
    private lateinit var viewModel: EditViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        supportActionBar?.title = "Edit movie"
        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(true)

        initViews()
        initViewModel()

    }

    private fun initViews(){
        edit_rv.layoutManager = LinearLayoutManager(this@EditActivity, RecyclerView.VERTICAL, false)
        edit_rv.adapter = editAdapter

    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(EditViewModel::class.java)

        viewModel.movies.observe(this, Observer {
            this@EditActivity.movies.clear()
            this@EditActivity.movies.addAll(it.sorted())
            editAdapter.notifyDataSetChanged()
        })
    }

    private fun onMovieClick(movie: Movie) {
        val intent = Intent(this, EditMovieDetails::class.java)
        intent.putExtra(EDIT_MOVIE, movie)
        startActivity(intent)
    }


    companion object {
        const val EDIT_MOVIE = "EDIT_MOVIE"
    }


}
