package com.edsusantoo.bismillah.moviecatalogue.data.local.db.dao

import androidx.paging.DataSource
import androidx.room.*
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.FavoritesEntity

@Dao
interface FavoritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(favoritesEntity: FavoritesEntity)

    @Delete
    fun delete(favoritesEntity: FavoritesEntity)

    @Query("SELECT * FROM favorites WHERE movie_id =:movie_id")
    fun getMovieFavorites(movie_id: Int): DataSource<Int, FavoritesEntity>
}