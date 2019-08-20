package com.edsusantoo.bismillah.moviecatalogue.ui.home.tvshows

import com.edsusantoo.bismillah.moviecatalogue.data.MoviesModel
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class TvShowsViewModelTest {
    private lateinit var viewModel: TvShowsViewModel

    @Before
    fun init() {
        viewModel = TvShowsViewModel()
    }

    @Test
    fun getTvShows() {
        val tvShows: List<MoviesModel> = viewModel.getTvShows()
        assertNotNull(tvShows)
    }

}