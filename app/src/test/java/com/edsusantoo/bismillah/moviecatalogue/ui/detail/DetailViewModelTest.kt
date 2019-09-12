package com.edsusantoo.bismillah.moviecatalogue.ui.detail

import com.edsusantoo.bismillah.moviecatalogue.data.local.other.MoviesModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dummyDetailMovie: MoviesModel

    @Before
    fun init() {
        viewModel = DetailViewModel()

        //aquaman
        val genresAquaman = ArrayList<String>()
        genresAquaman.add("Action")
        genresAquaman.add("Adventure")
        genresAquaman.add("Fantasy")
        dummyDetailMovie = MoviesModel(
            "Aquaman",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "68%",
            genresAquaman,
            "https://"
        )
    }

    @Test
    fun getDetail() {
        viewModel.setMovieDetail(dummyDetailMovie)
        val detail: MoviesModel? = viewModel.getMovieDetail()

        assertNotNull(detail)
        assertEquals(dummyDetailMovie.title, detail?.title)
    }
}