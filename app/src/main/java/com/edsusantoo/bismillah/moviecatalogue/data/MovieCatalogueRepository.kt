package com.edsusantoo.bismillah.moviecatalogue.data

import com.edsusantoo.bismillah.moviecatalogue.data.local.LocalRepository
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.FavoritesEntity
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesEntity
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

    override fun insertFavorites(favoritesEntity: FavoritesEntity) {
        localRepository?.insertFavorite(favoritesEntity)
    }

    override fun deleteFavorite(favoritesEntity: FavoritesEntity) {
        localRepository?.deleteFavorite(favoritesEntity)
    }

    override fun deleteMovie(moviesEntity: MoviesEntity) {
        localRepository?.deleteMovie(moviesEntity)
    }

    override fun insertMovies(moviesEntity: MoviesEntity) {
        localRepository?.insertMovie(moviesEntity)
    }

    override fun getMovieIfFavorite(movieId: Int): Maybe<FavoritesEntity>? {
        return localRepository?.getMovieIfFavorite(movieId)
    }


    override fun isCompositeDisposable(): CompositeDisposable {
        return compositeDisposable
    }

}