package nl.joevrolijk.topmoviesfavs.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "movieTable")
data class Movie (
    @ColumnInfo
    @SerializedName("popularity") val popularity : Double,

    @PrimaryKey
    @ColumnInfo
    @SerializedName("id") val id: Int?,

    @ColumnInfo
    @SerializedName("video") val video : Boolean,

    @ColumnInfo
    @SerializedName("vote_count") var vote_count: Int,

    @ColumnInfo
    @SerializedName("vote_average") val voteAverage : Double,

    @ColumnInfo
    @SerializedName("title") val title : String,

    @ColumnInfo
    @SerializedName("release_date") val releaseDate : String,

    @ColumnInfo
    @SerializedName("original_language") val originalLanguage : String,

    @ColumnInfo
    @SerializedName("original_title") val originalTitle : String,

    @ColumnInfo
    @SerializedName("backdrop_path") val backdropPath: String?,

//    @ColumnInfo
//    @SerializedName("genre_ids") val genreIds : List<Int>,

    @ColumnInfo
    @SerializedName("adult") val adult : Boolean,

    @ColumnInfo
    @SerializedName("overview") val overview : String,

    @ColumnInfo
    @SerializedName("poster_path") val posterPath: String?,

    @ColumnInfo
    var userRating: Double = 0.0


) : Parcelable, Comparable<Movie> {

    override fun compareTo(other: Movie): Int {
        when {
            userRating < other.userRating -> return 1
            userRating > other.userRating -> return -1
        }
        return 0
    }

    fun getPosterImageUrl() = "https://image.tmdb.org/t/p/w400/${posterPath}"
    fun getBackdropImageUrl() = "https://image.tmdb.org/t/p/w400/${backdropPath}"

}
