package com.edsusantoo.bismillah.moviecatalogue.data.local.db.dao

import androidx.room.*
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.FavoritesEntity
import io.reactivex.Maybe

@Dao
interface FavoritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(favoritesEntity: FavoritesEntity)

    @Delete
    fun delete(favoritesEntity: FavoritesEntity)

    @Query("SELECT * FROM favorites WHERE movie_id =:movie_id")
    fun getMovieIfFavorite(movie_id: Int): Maybe<FavoritesEntity>
}