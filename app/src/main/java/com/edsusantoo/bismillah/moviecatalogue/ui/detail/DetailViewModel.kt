package com.edsusantoo.bismillah.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.edsusantoo.bismillah.moviecatalogue.data.MovieCatalogueRepository
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesFavoritesEntity
import com.edsusantoo.bismillah.moviecatalogue.data.utils.MessageResponse
import com.edsusantoo.bismillah.moviecatalogue.data.utils.Resource


class DetailViewModel(
    private val movieCatalogueRepository: MovieCatalogueRepository?
) : ViewModel() {

    fun getMovieIsFavorite(movieName: String): LiveData<Resource<MoviesFavoritesEntity>> {
        return movieCatalogueRepository!!.getMoviesIfFavorites(movieName)
    }


    fun insertFavorite(moviesFavoritesEntity: MoviesFavoritesEntity): LiveData<Resource<MessageResponse>> {
        return movieCatalogueRepository!!.insertMovies(moviesFavoritesEntity)
    }


    fun deleteMovie(moviesFavoritesEntity: MoviesFavoritesEntity): LiveData<Resource<MessageResponse>> {
        return movieCatalogueRepository!!.deleteMovies(moviesFavoritesEntity)
    }

    override fun onCleared() {
        super.onCleared()
        movieCatalogueRepository?.isLocalCompositeDisposable()?.dispose()
    }
}