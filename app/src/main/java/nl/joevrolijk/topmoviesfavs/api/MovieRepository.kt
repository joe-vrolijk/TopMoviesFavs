package nl.joevrolijk.topmoviesfavs.api

class MovieRepository {
    private val movieApi: MovieApiService = MovieApi.createApi()

    fun searchMoviesByName(query: String) = movieApi.searchMoviesByName(query)
}
