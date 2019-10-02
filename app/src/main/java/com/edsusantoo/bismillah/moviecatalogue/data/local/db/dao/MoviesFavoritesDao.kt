package com.edsusantoo.bismillah.moviecatalogue.data.local.db.dao

import androidx.paging.DataSource
import androidx.room.*
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesFavoritesEntity
import io.reactivex.Maybe

@Dao
interface MoviesFavoritesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(moviesFavoritesEntity: MoviesFavoritesEntity)

    @Delete
    fun delete(moviesFavoritesEntity: MoviesFavoritesEntity)

    @Query("SELECT * FROM movies_favorites WHERE type =:type")
    fun getAllMoviesFavorites(type: String): DataSource.Factory<Int, MoviesFavoritesEntity>

    @Query("SELECT * FROM movies_favorites WHERE movie_name =:movieName")
    fun getMoviesIfFavorites(movieName: String): Maybe<MoviesFavoritesEntity>

}