package com.edsusantoo.bismillah.moviecatalogue.ui.home.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.edsusantoo.bismillah.moviecatalogue.data.local.other.MoviesCatalogueModel
import com.edsusantoo.bismillah.moviecatalogue.data.utils.Resource
import com.edsusantoo.bismillah.moviecatalogue.utils.FakeDataDummy
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class MoviesEntityViewModelTest {

    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    private var viewModel: MoviesViewModel = mock(MoviesViewModel::class.java)

    @Mock
    lateinit var observerGetMovie: Observer<Resource<MoviesCatalogueModel>>


    @Before
    fun init() {
        //to handle scheduler rx
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        //setup mock
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getMovie() {
        val dummyMovie = Resource.success(MoviesCatalogueModel(FakeDataDummy.getMovies()))

        val movie = MutableLiveData<Resource<MoviesCatalogueModel>>()
        movie.value = dummyMovie

        `when`(viewModel.getMovies()).thenReturn(movie)

        viewModel.getMovies()?.observeForever(observerGetMovie)

        verify(observerGetMovie).onChanged(dummyMovie)
    }
}