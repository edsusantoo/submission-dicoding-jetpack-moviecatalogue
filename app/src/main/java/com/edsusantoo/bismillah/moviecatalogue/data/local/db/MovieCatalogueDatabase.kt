package com.edsusantoo.bismillah.moviecatalogue.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.dao.MoviesFavoritesDao
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesFavoritesEntity

@Database(
    entities = [MoviesFavoritesEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MovieCatalogueDatabase : RoomDatabase() {
    abstract fun moviesFavoritesDao(): MoviesFavoritesDao

    companion object {
        private var INSTANCE: MovieCatalogueDatabase? = null
        fun getInstance(context: Context): MovieCatalogueDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieCatalogueDatabase::class.java,
                    "MovieCatalogue.db"
                )
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}