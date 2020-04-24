package nl.joevrolijk.topmoviesfavs.db

import android.content.Context
import androidx.lifecycle.LiveData
import nl.joevrolijk.topmoviesfavs.model.Movie

class MovieDbRepository(context: Context) {

    private val movieDao: MovieDao

    init {
        val database = MovieRoomDatabase.getDatabase(context)
        movieDao = database!!.movieDao()
    }

    fun getMovies(): LiveData<List<Movie>> {
        return movieDao.getMovies()
    }

    fun insertMovie(movie: Movie) {
        movieDao.insertMovie(movie)
    }

    suspend fun deleteMovie(movie: Movie) {
        movieDao.deleteMovie(movie)
    }

    suspend fun updateMovie(movie: Movie) {
        movieDao.updateMovie(movie)
    }


}
