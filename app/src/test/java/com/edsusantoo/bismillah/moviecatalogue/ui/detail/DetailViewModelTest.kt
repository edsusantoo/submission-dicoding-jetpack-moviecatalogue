package com.edsusantoo.bismillah.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesFavoritesEntity
import com.edsusantoo.bismillah.moviecatalogue.utils.DataConverter
import com.edsusantoo.bismillah.moviecatalogue.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations


class DetailViewModelTest {

    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dummyMoviesFavorites: MoviesFavoritesEntity

    private var viewModel = mock(DetailViewModel::class.java)

    @Mock
    lateinit var observerMoviesIsFavorite: Observer<MoviesFavoritesEntity>


    @Before
    fun init() {

        //to handle scheduler rx
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        //setup mock
        MockitoAnnotations.initMocks(this)

        //aquaman
        val genresAquaman = ArrayList<String>()
        genresAquaman.add("Action")
        genresAquaman.add("Adventure")
        genresAquaman.add("Fantasy")
        dummyMoviesFavorites = MoviesFavoritesEntity(
            "Aquaman",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            DataConverter.listToJsonString(genresAquaman),
            "68%",
            "movie",
            "https://"
        )

    }

    @Test
    fun insert_than_get_movies_is_favorites() {
        viewModel.insertFavorite(dummyMoviesFavorites)

        val moviesFavorites: MutableLiveData<MoviesFavoritesEntity> = MutableLiveData()
        moviesFavorites.value = dummyMoviesFavorites

        `when`(viewModel.getMovieIsFavorite("au")).thenReturn(moviesFavorites)

        viewModel.getMovieIsFavorite("au").observeForever(observerMoviesIsFavorite)

        verify(observerMoviesIsFavorite).onChanged(dummyMoviesFavorites)


        val moviesTest = LiveDataTestUtil.getValue(viewModel.getMovieIsFavorite("au"))
        assertEquals("Aquaman", moviesTest.movie_name)


    }

    @Test
    fun insert_delete_then_get_movies_not_favorites() {
        viewModel.insertFavorite(dummyMoviesFavorites)
        viewModel.deleteMovie(dummyMoviesFavorites)

        val moviesFavorites: MutableLiveData<MoviesFavoritesEntity> = MutableLiveData()
        moviesFavorites.value = dummyMoviesFavorites

        `when`(viewModel.getMovieIsFavorite("Aquaman")).thenReturn(moviesFavorites)

        viewModel.getMovieIsFavorite("Aquaman").observeForever(observerMoviesIsFavorite)

        verify(observerMoviesIsFavorite).onChanged(dummyMoviesFavorites)

        val moviestest = LiveDataTestUtil.getValue(viewModel.getMovieIsFavorite("Aquaman"))

        assertNotNull(moviestest)
        assertNotEquals("Batman", moviestest.movie_name)

    }
}