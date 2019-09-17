package com.edsusantoo.bismillah.moviecatalogue.data

import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.FavoritesEntity
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesEntity
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

    fun getAllFavorites(): Maybe<List<FavoritesEntity>>?

    fun getMoviesWhereType(movieId: Int, type: String): Maybe<List<MoviesEntity>>?

    fun insertFavorites(favoritesEntity: FavoritesEntity)

    fun deleteFavorite(favoritesEntity: FavoritesEntity)

    fun deleteMovie(moviesEntity: MoviesEntity)

    fun insertMovies(moviesEntity: MoviesEntity)

    fun getMovieIfFavorite(movieId: Int): Maybe<FavoritesEntity>?

    fun isCompositeDisposable(): CompositeDisposable


}
