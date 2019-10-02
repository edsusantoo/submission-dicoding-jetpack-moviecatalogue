package com.edsusantoo.bismillah.moviecatalogue.ui.home.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.edsusantoo.bismillah.moviecatalogue.data.MovieCatalogueRepository
import com.edsusantoo.bismillah.moviecatalogue.data.local.other.MoviesCatalogueModel
import com.edsusantoo.bismillah.moviecatalogue.data.utils.Resource

class TvShowsViewModel(
    private val movieCatalogueRepository: MovieCatalogueRepository?
) : ViewModel() {

    fun getTvShows(): LiveData<Resource<MoviesCatalogueModel>>? {
        return movieCatalogueRepository?.getTvShows("en-US")
    }


    override fun onCleared() {
        super.onCleared()
        movieCatalogueRepository?.isCompositeDisposable()?.dispose()
    }
}
