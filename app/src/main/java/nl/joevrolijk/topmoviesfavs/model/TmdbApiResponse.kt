package nl.joevrolijk.topmoviesfavs.model

import com.google.gson.annotations.SerializedName

data class TmdbApiResponse(
    @SerializedName("page") var page: Int,
    @SerializedName("total_result") var totalResult: Int,
    @SerializedName("total_pages") var totalPages: Int,
    @SerializedName("results") var results: List<Movie>
) {
}
