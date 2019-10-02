package com.edsusantoo.bismillah.moviecatalogue.ui.home.tvshows

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

class TvShowsViewModelTest {
    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    private var viewModel: TvShowsViewModel = mock(TvShowsViewModel::class.java)

    @Mock
    lateinit var observerGetTvShows: Observer<Resource<MoviesCatalogueModel>>

    @Before
    fun init() {
        //to handle scheduler rx
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        //setup mock
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getTvShows() {
        val dummyTvShows = Resource.success(MoviesCatalogueModel(FakeDataDummy.getTvShows()))

        val tvShows = MutableLiveData<Resource<MoviesCatalogueModel>>()
        tvShows.value = dummyTvShows

        `when`(viewModel.getTvShows()).thenReturn(tvShows)

        viewModel.getTvShows()?.observeForever(observerGetTvShows)

        verify(observerGetTvShows).onChanged(dummyTvShows)

    }

}