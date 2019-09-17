package com.edsusantoo.bismillah.moviecatalogue.data.local

import androidx.paging.DataSource
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.dao.FavoritesDao
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.dao.MoviesDao
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.dao.MoviesFavoritesDao
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesFavoritesEntity
import io.reactivex.Maybe

class LocalRepository(
    private val moviesDao: MoviesDao,
    private val favoritesDao: FavoritesDao,
    private var moviesFavoritesDao: MoviesFavoritesDao
) {
    companion object {
        private var INSTANCE: LocalRepository? = null
        fun getInstance(
            moviesDao: MoviesDao,
            favoritesDao: FavoritesDao,
            moviesFavoritesDao: MoviesFavoritesDao
        ): LocalRepository? {
            if (INSTANCE == null) {
                INSTANCE = LocalRepository(moviesDao, favoritesDao, moviesFavoritesDao)
            }

            return INSTANCE
        }
    }

    fun insertMoviesFavorites(moviesFavoritesEntity: MoviesFavoritesEntity) {
        moviesFavoritesDao.insert(moviesFavoritesEntity)
    }

    fun deleteMoviesFavorites(moviesFavoritesEntity: MoviesFavoritesEntity) {
        moviesFavoritesDao.delete(moviesFavoritesEntity)
    }

    fun getMoviesIfFavorites(movieName: String): Maybe<MoviesFavoritesEntity> {
        return moviesFavoritesDao.getMoviesIfFavorites(movieName)
    }

    fun getAllMoviesFavorites(type: String): DataSource.Factory<Int, MoviesFavoritesEntity> {
        return moviesFavoritesDao.getAllMoviesFavorites(type)
    }

}