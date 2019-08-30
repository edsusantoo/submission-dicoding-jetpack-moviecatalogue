package com.edsusantoo.bismillah.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.edsusantoo.bismillah.moviecatalogue.data.local.MoviesModel

class DetailViewModel : ViewModel() {
    private var moviesModel: MoviesModel? = null


    fun setMovieDetail(movies: MoviesModel) {
        moviesModel = movies
    }

    fun getMovieDetail(): MoviesModel? {
        return moviesModel
    }
}