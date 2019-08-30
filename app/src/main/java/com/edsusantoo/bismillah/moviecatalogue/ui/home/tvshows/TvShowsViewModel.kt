package com.edsusantoo.bismillah.moviecatalogue.ui.home.tvshows

import androidx.lifecycle.ViewModel
import com.edsusantoo.bismillah.moviecatalogue.data.local.MoviesModel
import com.edsusantoo.bismillah.moviecatalogue.utils.DataDummy

class TvShowsViewModel : ViewModel() {
    fun getTvShows(): List<MoviesModel> {
        return DataDummy.getTvShows()
    }
}
