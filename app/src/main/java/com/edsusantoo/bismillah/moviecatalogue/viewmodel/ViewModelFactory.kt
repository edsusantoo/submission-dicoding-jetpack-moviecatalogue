package com.edsusantoo.bismillah.moviecatalogue.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.edsusantoo.bismillah.moviecatalogue.data.MovieCatalogueRepository
import com.edsusantoo.bismillah.moviecatalogue.di.Injection
import com.edsusantoo.bismillah.moviecatalogue.ui.detail.DetailViewModel
import com.edsusantoo.bismillah.moviecatalogue.ui.home.favorites.movies.MoviesFavoriteViewModel
import com.edsusantoo.bismillah.moviecatalogue.ui.home.favorites.tvshows.TvShowsFavoriteViewModel
import com.edsusantoo.bismillah.moviecatalogue.ui.home.movies.MoviesViewModel
import com.edsusantoo.bismillah.moviecatalogue.ui.home.tvshows.TvShowsViewModel

class ViewModelFactory(private val movieCatalogueRepository: MovieCatalogueRepository?) : ViewModelProvider.Factory {

    companion object {
        private var INSTANCE: ViewModelFactory? = null
        fun getInstance(application: Application): ViewModelFactory? {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = ViewModelFactory(Injection.provideRepository(application))
                }
            }

            return INSTANCE
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> MoviesViewModel(movieCatalogueRepository) as T
            modelClass.isAssignableFrom(TvShowsViewModel::class.java) -> TvShowsViewModel(movieCatalogueRepository) as T
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> DetailViewModel(movieCatalogueRepository) as T
            modelClass.isAssignableFrom(MoviesFavoriteViewModel::class.java) -> MoviesFavoriteViewModel(
                movieCatalogueRepository
            ) as T
            modelClass.isAssignableFrom(TvShowsFavoriteViewModel::class.java) -> TvShowsFavoriteViewModel(
                movieCatalogueRepository
            ) as T
            else -> throw IllegalArgumentException("Unknown ViewModel Class: " + modelClass.name)
        }
    }

}