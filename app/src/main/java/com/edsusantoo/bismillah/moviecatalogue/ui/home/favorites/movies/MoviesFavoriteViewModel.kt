package com.edsusantoo.bismillah.moviecatalogue.ui.home.favorites.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.edsusantoo.bismillah.moviecatalogue.data.MovieCatalogueRepository
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesFavoritesEntity

class MoviesFavoriteViewModel(
    private val movieCatalogueRepository: MovieCatalogueRepository?
) : ViewModel() {

    fun getAllMoviesFavorites(type: String): LiveData<PagedList<MoviesFavoritesEntity>> {
        return LivePagedListBuilder(movieCatalogueRepository?.getAllMoviesFavorites(type)!!, 5).build()
    }

    override fun onCleared() {
        super.onCleared()
        movieCatalogueRepository?.isLocalCompositeDisposable()?.dispose()
    }


}