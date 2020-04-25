package nl.joevrolijk.topmoviesfavs.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import nl.joevrolijk.topmoviesfavs.db.MovieDbRepository
import nl.joevrolijk.topmoviesfavs.model.Movie

class MovieDetailsViewModel(application: Application) : AndroidViewModel(application) {

    private val scope = CoroutineScope(Dispatchers.IO)
    private val movieDbRepository = MovieDbRepository(application.applicationContext)

    fun insertMovie(movie: Movie){
        scope.launch {
            movieDbRepository.insertMovie(movie);
        }
    }


}
