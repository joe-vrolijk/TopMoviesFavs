package nl.joevrolijk.topmoviesfavs.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import nl.joevrolijk.topmoviesfavs.api.MovieRepository
import nl.joevrolijk.topmoviesfavs.model.Movie
import nl.joevrolijk.topmoviesfavs.model.TmdbApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel(application: Application) : AndroidViewModel(application) {

    private val movieRepository = MovieRepository()
    val movies = MutableLiveData<List<Movie>>()
    val error = MutableLiveData<String>()

    fun searchMovieByName(query: String) {
        movieRepository.searchMoviesByName(query).enqueue(object : Callback<TmdbApiResponse> {
            override fun onResponse(
                call: Call<TmdbApiResponse>,
                response: Response<TmdbApiResponse>
            ) {
                if (response.isSuccessful) {
                    val searchMoviesByName = response.body()
                    movies.value = searchMoviesByName?.results
                } else {
                    error.value = "An error has occured: ${response.errorBody().toString()}"
                }
            }

            override fun onFailure(call: Call<TmdbApiResponse>, t: Throwable) {
                error.value = t.message
            }

        })
    }
}
