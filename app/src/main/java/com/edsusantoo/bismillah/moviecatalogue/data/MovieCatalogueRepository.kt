package com.edsusantoo.bismillah.moviecatalogue.data

import androidx.paging.DataSource
import com.edsusantoo.bismillah.moviecatalogue.data.local.LocalRepository
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesFavoritesEntity
import com.edsusantoo.bismillah.moviecatalogue.data.remote.RemoteRepository
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.genres.GenresResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.movie.MoviesResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.tvshows.TvShowsResponse
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class MovieCatalogueRepository(
    private val localRepository: LocalRepository?,
    private val remoteRepository: RemoteRepository
) : MovieCatalogueDataSource {
    companion object {
        private var INSTANCE: MovieCatalogueRepository? = null
        fun getInstance(
            localRepository: LocalRepository?,
            remoteRepository: RemoteRepository
        ): MovieCatalogueRepository? {
            if (INSTANCE == null) {
                INSTANCE = MovieCatalogueRepository(localRepository, remoteRepository)
            }

            return INSTANCE
        }
    }

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()


    override fun getMovies(language: String): Single<MoviesResponse> {
        return remoteRepository.getMovies(language)
    }

    override fun getTvShows(language: String): Single<TvShowsResponse> {
        return remoteRepository.getTvShows(language)
    }

    override fun getGenresMovies(): Single<GenresResponse> {
        return remoteRepository.getGenresMovies()
    }

    override fun getGenresTvShows(): Single<GenresResponse> {
        return remoteRepository.getGenresTvShows()
    }

    override fun insertMoviesFavorites(moviesFavoritesEntity: MoviesFavoritesEntity) {
        localRepository?.insertMoviesFavorites(moviesFavoritesEntity)
    }

    override fun deleteMoviesFavorites(moviesFavoritesEntity: MoviesFavoritesEntity) {
        localRepository?.deleteMoviesFavorites(moviesFavoritesEntity)
    }

    override fun getAllMoviesFavorites(type: String): DataSource.Factory<Int, MoviesFavoritesEntity>? {
        return localRepository?.getAllMoviesFavorites(type)
    }

    override fun getMoviesIfFavorites(movieName: String): Maybe<MoviesFavoritesEntity>? {
        return localRepository?.getMoviesIfFavorites(movieName)
    }

    override fun isCompositeDisposable(): CompositeDisposable {
        return compositeDisposable
    }

}