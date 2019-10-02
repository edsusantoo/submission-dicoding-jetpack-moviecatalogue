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
        if (movieCatalogueRepository?.isRemoteCompositeDisposable() != null) {
            movieCatalogueRepository.isRemoteCompositeDisposable().clear()
        }
//TODO:compositedisposable
// Using clear will clear all, but can accept new disposable
//        disposables.clear();
// Using dispose will clear all and set isDisposed = true, so it will not accept any new disposable
//        disposables.dispose();

    }
}