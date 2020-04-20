package nl.joevrolijk.topmoviesfavs.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    @SerializedName("popularity") val popularity : Double,
    @SerializedName("id") val id : Int,
    @SerializedName("video") val video : Boolean,
    @SerializedName("vote_count") var vote_count: Int,
    @SerializedName("vote_average") val voteAverage : Double,
    @SerializedName("title") val title : String,
    @SerializedName("release_date") val releaseDate : String,
    @SerializedName("original_language") val originalLanguage : String,
    @SerializedName("original_title") val originalTitle : String,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("genre_ids") val genreIds : List<Int>,
    @SerializedName("adult") val adult : Boolean,
    @SerializedName("overview") val overview : String,
    @SerializedName("poster_path") val posterPath: String?


): Parcelable {
    fun getPosterImageUrl() = "https://image.tmdb.org/t/p/w400/${posterPath}"
    fun getBackdropImageUrl() = "https://image.tmdb.org/t/p/w400/${backdropPath}"

}
