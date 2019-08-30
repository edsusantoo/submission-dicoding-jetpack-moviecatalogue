package com.edsusantoo.bismillah.moviecatalogue.data

import com.edsusantoo.bismillah.moviecatalogue.data.remote.RemoteConfig
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.genres.GenresResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.movie.MoviesResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.tvshows.TvShowsResponse
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class MovieCatalogueRepository : MovieCatalogueDataSource {
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()


    override fun getMovies(api_key: String, language: String): Single<MoviesResponse> {
        return RemoteConfig.getRemoteApiStore().getMovie(api_key, language)
    }

    override fun getTvShows(api_key: String, language: String): Single<TvShowsResponse> {
        return RemoteConfig.getRemoteApiStore().getTvShows(api_key, language)
    }

    override fun getGenresMovies(api_key: String): Single<GenresResponse> {
        return RemoteConfig.getRemoteApiStore().getGenresMovie(api_key)
    }

    override fun getGenresTvShows(api_key: String): Single<GenresResponse> {
        return RemoteConfig.getRemoteApiStore().getGenresTv(api_key)
    }

    override fun isCompositeDisposable(): CompositeDisposable {
        return compositeDisposable
    }

}