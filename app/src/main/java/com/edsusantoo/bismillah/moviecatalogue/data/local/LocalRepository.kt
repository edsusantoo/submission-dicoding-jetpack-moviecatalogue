package com.edsusantoo.bismillah.moviecatalogue.data.local

import androidx.lifecycle.LiveData
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.dao.FavoritesDao
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.dao.MoviesDao
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.FavoritesEntity
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesEntity
import io.reactivex.Maybe

class LocalRepository(
    private val moviesDao: MoviesDao,
    private val favoritesDao: FavoritesDao
) {
    companion object {
        private var INSTANCE: LocalRepository? = null
        fun getInstance(moviesDao: MoviesDao, favoritesDao: FavoritesDao): LocalRepository? {
            if (INSTANCE == null) {
                INSTANCE = LocalRepository(moviesDao, favoritesDao)
            }

            return INSTANCE
        }
    }

    fun insertFavorite(favoritesEntity: FavoritesEntity) {
        favoritesDao.insert(favoritesEntity)
    }

    fun insertMovie(moviesEntity: MoviesEntity) {
        moviesDao.insert(moviesEntity)
    }

    fun deleteFavorite(favoritesEntity: FavoritesEntity) {
        favoritesDao.delete(favoritesEntity)
    }

    fun deleteMovie(moviesEntity: MoviesEntity) {
        moviesDao.delete(moviesEntity)
    }

    fun getMovieIfFavorite(movie_id: Int): Maybe<FavoritesEntity> {
        return favoritesDao.getMovieIfFavorite(movie_id)
    }

    fun getMovies(): LiveData<MoviesEntity> {
        return moviesDao.getAllMovie()
    }

}