package com.edsusantoo.bismillah.moviecatalogue.data

import androidx.paging.DataSource
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesFavoritesEntity
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.genres.GenresResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.movie.MoviesResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.tvshows.TvShowsResponse
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

interface MovieCatalogueDataSource {

    fun getMovies(language: String): Single<MoviesResponse>

    fun getTvShows(language: String): Single<TvShowsResponse>

    fun getGenresTvShows(): Single<GenresResponse>

    fun getGenresMovies(): Single<GenresResponse>

    fun getMoviesIfFavorites(movieName: String): Maybe<MoviesFavoritesEntity>?

    fun getAllMoviesFavorites(type: String): DataSource.Factory<Int, MoviesFavoritesEntity>?

    fun insertMoviesFavorites(moviesFavoritesEntity: MoviesFavoritesEntity)

    fun deleteMoviesFavorites(moviesFavoritesEntity: MoviesFavoritesEntity)

    fun isCompositeDisposable(): CompositeDisposable


}
