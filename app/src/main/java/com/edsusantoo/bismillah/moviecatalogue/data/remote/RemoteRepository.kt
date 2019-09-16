package com.edsusantoo.bismillah.moviecatalogue.data.remote

import com.edsusantoo.bismillah.moviecatalogue.BuildConfig
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.genres.GenresResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.movie.MoviesResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.tvshows.TvShowsResponse
import io.reactivex.Single

class RemoteRepository {

    fun getMovies(language: String): Single<MoviesResponse> {
        return RemoteConfig.getRemoteApiStore().getMovie(BuildConfig.API_KEY, language)
    }

    fun getTvShows(language: String): Single<TvShowsResponse> {
        return RemoteConfig.getRemoteApiStore().getTvShows(BuildConfig.API_KEY, language)
    }

    fun getGenresMovies(): Single<GenresResponse> {
        return RemoteConfig.getRemoteApiStore().getGenresMovie(BuildConfig.API_KEY)
    }

    fun getGenresTvShows(): Single<GenresResponse> {
        return RemoteConfig.getRemoteApiStore().getGenresTv(BuildConfig.API_KEY)
    }
}