package com.edsusantoo.bismillah.moviecatalogue.data.local.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MoviesEntity(
    @ColumnInfo(name = "movie_name")
    var movie_name: String,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "genre")
    var genre: String,
    @ColumnInfo(name = "rate")
    var rate: String,
    @ColumnInfo(name = "type")
    var type: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "movie_id")
    val movieId: Int = 0
}