package nl.joevrolijk.topmoviesfavs.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import nl.joevrolijk.topmoviesfavs.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
//todo ADD TYPECONVERTERS HERE
abstract class MovieRoomDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private const val DATABASE_NAME = "MOVIE_DB"

        @Volatile
        private var INSTANCE: MovieRoomDatabase? = null

        fun getDatabase(context: Context): MovieRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(MovieRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext, MovieRoomDatabase::class.java, DATABASE_NAME
                        ).build()
                    }
                }
            }
            return INSTANCE
        }
    }

}
