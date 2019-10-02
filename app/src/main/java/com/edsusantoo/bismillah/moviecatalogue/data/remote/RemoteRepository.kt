package com.edsusantoo.bismillah.moviecatalogue.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.edsusantoo.bismillah.moviecatalogue.BuildConfig
import com.edsusantoo.bismillah.moviecatalogue.data.local.other.MoviesCatalogueModel
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.genres.GenresResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.movie.MoviesResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.tvshows.TvShowsResponse
import com.edsusantoo.bismillah.moviecatalogue.data.utils.Resource
import com.edsusantoo.bismillah.moviecatalogue.utils.CombineData
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

class RemoteRepository {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getMovies(language: String): LiveData<Resource<MoviesCatalogueModel>> {
        val data = MutableLiveData<Resource<MoviesCatalogueModel>>()
        compositeDisposable.add(
            Single.zip(
                RemoteConfig.getRemoteApiStore().getMovie(BuildConfig.API_KEY, language),
                RemoteConfig.getRemoteApiStore().getGenresMovie(BuildConfig.API_KEY),
                BiFunction<MoviesResponse, GenresResponse, Unit>
                { movies, genres -> CombineData.setMoviesAndGenres(movies, genres) }
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        data.value = Resource.success(CombineData.movies_genres.value!!)
                    },
                    {
                        data.value = Resource.error(it.message)
                    }
                )
        )
        return data
    }

    fun getTvShows(language: String): LiveData<Resource<MoviesCatalogueModel>> {

        val data = MutableLiveData<Resource<MoviesCatalogueModel>>()

        compositeDisposable.add(
            Single.zip(
                RemoteConfig.getRemoteApiStore().getTvShows(BuildConfig.API_KEY, "en-US"),
                RemoteConfig.getRemoteApiStore().getGenresTv(BuildConfig.API_KEY),
                BiFunction<TvShowsResponse, GenresResponse, Unit> { tv_shows, genres ->
                    CombineData.setTvShowsAndGenres(tv_shows, genres)
                }
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        data.value = Resource.success(CombineData.movies_genres.value!!)

                    },
                    {
                        data.value = Resource.error(it.message)
                    }
                )
        )

        return data
    }


    fun isCompositeDisposable(): CompositeDisposable {
        return compositeDisposable
    }
}