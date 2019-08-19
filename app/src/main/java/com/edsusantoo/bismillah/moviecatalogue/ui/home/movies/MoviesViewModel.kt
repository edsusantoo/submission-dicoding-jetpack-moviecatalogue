package com.edsusantoo.bismillah.moviecatalogue.ui.home.movies

import androidx.lifecycle.ViewModel
import com.edsusantoo.bismillah.moviecatalogue.data.MoviesModel
import com.edsusantoo.bismillah.moviecatalogue.utils.DataDummy

class MoviesViewModel : ViewModel() {
    fun getMovies(): List<MoviesModel> {
        return DataDummy.getMovies()
    }
}