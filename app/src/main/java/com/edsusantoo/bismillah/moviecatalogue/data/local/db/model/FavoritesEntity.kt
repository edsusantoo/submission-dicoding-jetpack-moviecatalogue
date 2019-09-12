package com.edsusantoo.bismillah.moviecatalogue.data.local.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "favorites",
    foreignKeys = [ForeignKey(
        entity = MoviesEntity::class,
        parentColumns = ["movie_id"],
        childColumns = ["movie_id"],
        onDelete = CASCADE
    )]
)
data class FavoritesEntity(
    @ColumnInfo(name = "movie_id")
    var movieId: Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "favorite_id")
    val favoriteId: Int = 0
}