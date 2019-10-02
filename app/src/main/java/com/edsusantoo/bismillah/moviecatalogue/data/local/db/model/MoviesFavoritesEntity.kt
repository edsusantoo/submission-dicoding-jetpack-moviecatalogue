package com.edsusantoo.bismillah.moviecatalogue.data.local.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies_favorites")
data class MoviesFavoritesEntity(
    @ColumnInfo(name = "movie_id")
    var movie_id: Int,
    @ColumnInfo(name = "movie_name")
    var movie_name: String,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "genre")
    var genre: String,
    @ColumnInfo(name = "rate")
    var rate: String,
    @ColumnInfo(name = "type")
    var type: String,
    @ColumnInfo(name = "image")
    var image: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "movies_favorites_id")
    var favoriteId: Int = 0
}