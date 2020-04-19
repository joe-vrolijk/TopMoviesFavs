package nl.joevrolijk.topmoviesfavs.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_search_movie.*
import nl.joevrolijk.topmoviesfavs.R
import nl.joevrolijk.topmoviesfavs.model.Movie
import nl.joevrolijk.topmoviesfavs.viewmodel.SearchViewModel

class SearchMovie : AppCompatActivity() {

    private lateinit var viewModel: SearchViewModel
    private val movies = arrayListOf<Movie>()
    private val searchMovieAdapter = SearchMovieAdapter(movies, { movie -> onMovieClick(movie) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_movie)

        initView()
        initViewModel()
    }

    private fun initView() {
        rv_search_result.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)
        rv_search_result.adapter = searchMovieAdapter

        submit_movie_search.setOnClickListener {
            onSearchSubmit()
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)

        viewModel.movies.observe(this, Observer {
            this@SearchMovie.movies.clear()
            this@SearchMovie.movies.addAll(it)
            searchMovieAdapter.notifyDataSetChanged()
        })

        viewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            Log.d("Failed response", it)
        })
    }


    private fun onSearchSubmit() {
        var query = input_movie.text.toString()
        if (query.isNotBlank()) {
            viewModel.searchMovieByName(query)
        }
    }

    private fun onMovieClick(movie: Movie) {
        Toast.makeText(this, "CLICKED ON MOVIE: " + movie.title, Toast.LENGTH_LONG).show()
    }

    companion object {
        const val EXTRA_MOVIE = "EXTRA_MOVIE"
    }



}
