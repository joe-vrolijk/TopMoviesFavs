package nl.joevrolijk.topmoviesfavs.db

import androidx.lifecycle.LiveData
import androidx.room.*
import nl.joevrolijk.topmoviesfavs.model.Movie

@Dao
interface MovieDao {

    @Insert
    fun insertMovie(movie: Movie)

    @Query("select * from movieTable")
    fun getMovies(): LiveData<List<Movie>>

    @Delete
    suspend fun deleteMovie(movie: Movie)

    @Update
    suspend fun updateMovie(movie: Movie)

}
