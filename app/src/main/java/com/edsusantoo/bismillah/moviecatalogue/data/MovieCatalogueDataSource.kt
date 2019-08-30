package com.edsusantoo.bismillah.moviecatalogue.data

import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.genres.GenresResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.movie.MoviesResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.tvshows.TvShowsResponse
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

interface MovieCatalogueDataSource {

    fun getMovies(api_key: String, language: String): Single<MoviesResponse>

    fun getTvShows(api_key: String, language: String): Single<TvShowsResponse>

    fun getGenresTvShows(api_key: String): Single<GenresResponse>

    fun getGenresMovies(api_key: String): Single<GenresResponse>


    fun isCompositeDisposable(): CompositeDisposable


}
