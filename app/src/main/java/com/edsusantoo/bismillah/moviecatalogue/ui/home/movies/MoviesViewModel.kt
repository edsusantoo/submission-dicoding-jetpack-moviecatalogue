package com.edsusantoo.bismillah.moviecatalogue.ui.home.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.edsusantoo.bismillah.moviecatalogue.data.MovieCatalogueRepository
import com.edsusantoo.bismillah.moviecatalogue.data.local.other.MoviesCatalogueModel
import com.edsusantoo.bismillah.moviecatalogue.data.utils.Resource

class MoviesViewModel(
    private val movieCatalogueRepository: MovieCatalogueRepository?
) : ViewModel() {

    fun getMovies(): LiveData<Resource<MoviesCatalogueModel>>? {
        return movieCatalogueRepository?.getMovies("en-US")
    }

    override fun onCleared() {
        super.onCleared()
        movieCatalogueRepository?.isCompositeDisposable()?.dispose()
    }
}