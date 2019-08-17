package com.sulistyo.moviecatalogueapi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sulistyo.moviecatalogueapi.data.model.MovieFavorite
import com.sulistyo.moviecatalogueapi.data.model.TvFavorite

@Database(entities = [MovieFavorite::class, TvFavorite::class], version = 2)
abstract class Favorite : RoomDatabase() {

    abstract fun dataDao(): DataDAO

    companion object {
        private var INSTANCE: Favorite? = null

        fun getInstance(context: Context): Favorite? {
            if (INSTANCE == null) {
                synchronized(Favorite::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        Favorite::class.java, "favorite.db"
                    )
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}