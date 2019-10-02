package com.edsusantoo.bismillah.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesFavoritesEntity
import com.edsusantoo.bismillah.moviecatalogue.data.local.other.MoviesCatalogueModel
import com.edsusantoo.bismillah.moviecatalogue.data.utils.MessageResponse
import com.edsusantoo.bismillah.moviecatalogue.data.utils.Resource
import io.reactivex.disposables.CompositeDisposable

interface MovieCatalogueDataSource {

    fun isCompositeDisposable(): CompositeDisposable

    fun getMovies(language: String): LiveData<Resource<MoviesCatalogueModel>>

    fun getTvShows(language: String): LiveData<Resource<MoviesCatalogueModel>>

    fun insertMovies(moviesFavoritesEntity: MoviesFavoritesEntity): LiveData<Resource<MessageResponse>>

    fun deleteMovies(moviesFavoritesEntity: MoviesFavoritesEntity): LiveData<Resource<MessageResponse>>

    fun getMoviesIfFavorites(movieName: String): LiveData<Resource<MoviesFavoritesEntity>>

    fun getAllMoviesFavorites(type: String): DataSource.Factory<Int, MoviesFavoritesEntity>?



}
