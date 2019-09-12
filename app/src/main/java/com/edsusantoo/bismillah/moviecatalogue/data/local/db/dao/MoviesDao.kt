package com.edsusantoo.bismillah.moviecatalogue.data.local.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesEntity

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(moviesEntity: MoviesEntity)

    @Delete
    fun delete(moviesEntity: MoviesEntity)

    @Query("SELECT * FROM movie ")
    fun getAllMovie(): LiveData<MoviesEntity>
}