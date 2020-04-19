package nl.joevrolijk.topmoviesfavs.api

import nl.joevrolijk.topmoviesfavs.model.TmdbApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("/3/search/movie?api_key=8a6e54873261843a10f56fffb36f93da&language=en-US&include_adult=false")
    fun searchMoviesByName(@Query("query") query : String) : Call<TmdbApiResponse>


}
