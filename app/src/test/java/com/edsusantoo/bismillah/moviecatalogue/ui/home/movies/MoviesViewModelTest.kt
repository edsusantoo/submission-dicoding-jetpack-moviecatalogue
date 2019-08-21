package com.edsusantoo.bismillah.moviecatalogue.ui.home.movies

import com.edsusantoo.bismillah.moviecatalogue.data.MoviesModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MoviesViewModelTest {
    private lateinit var viewModel: MoviesViewModel

    @Before
    fun init() {
        viewModel = MoviesViewModel()
    }

    @Test
    fun getMovie() {
        val movies: List<MoviesModel> = viewModel.getMovies()
        assertNotNull(movies)
        assertEquals("Aquaman", movies[0].title)
        assertEquals(11, movies.size)
    }
}