package nl.joevrolijk.topmoviesfavs.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import nl.joevrolijk.topmoviesfavs.db.MovieDbRepository
import nl.joevrolijk.topmoviesfavs.model.Movie

class EditViewModel(application: Application): AndroidViewModel(application) {
    private val scope = CoroutineScope(Dispatchers.IO)
    private val movieDbRepository = MovieDbRepository(application.applicationContext)

    val movies: LiveData<List<Movie>> = movieDbRepository.getMovies()

    fun updateMovie(movie: Movie){
        scope.launch {
            movieDbRepository.updateMovie(movie)
        }
    }

}
