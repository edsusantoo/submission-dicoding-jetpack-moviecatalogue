package com.edsusantoo.bismillah.moviecatalogue.ui.home.favorites.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesFavoritesEntity
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class TvShowsFavoriteViewModelTest {
    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    private var viewModel = mock(TvShowsFavoriteViewModel::class.java)

    @Mock
    lateinit var observerMoviesFavorites: Observer<PagedList<MoviesFavoritesEntity>>

    @Before
    fun init() {
        //to handle scheduler rx
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        //setup mock
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getMoviesFavorites() {
        val dummyMoviesFavorites = MutableLiveData<PagedList<MoviesFavoritesEntity>>()
        val pagedList = mock(PagedList::class.java) as PagedList<MoviesFavoritesEntity>

        dummyMoviesFavorites.value = pagedList

        `when`(viewModel.getAllMoviesFavorites("tvshow")).thenReturn(dummyMoviesFavorites)

        viewModel.getAllMoviesFavorites("tvshow").observeForever(observerMoviesFavorites)

        verify(observerMoviesFavorites).onChanged(pagedList)

    }
}