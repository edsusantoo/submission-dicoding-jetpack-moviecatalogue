package com.edsusantoo.bismillah.moviecatalogue.data.local.db.dao

import androidx.room.*
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesEntity
import io.reactivex.Maybe

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(moviesEntity: MoviesEntity)

    @Delete
    fun delete(moviesEntity: MoviesEntity)

    @Query("SELECT * FROM movie WHERE movie_id =:movieId AND type =:type")
    fun getMoviesWhereType(movieId: Int, type: String): Maybe<List<MoviesEntity>>
}