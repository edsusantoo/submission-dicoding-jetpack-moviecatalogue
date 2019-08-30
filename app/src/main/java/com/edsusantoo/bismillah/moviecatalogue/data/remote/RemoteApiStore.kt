package com.edsusantoo.bismillah.moviecatalogue.data.remote

import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.genres.GenresResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.movie.MoviesResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.tvshows.TvShowsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteApiStore {
    @GET("discover/movie")
    fun getMovie(
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ): Single<MoviesResponse>

    @GET("discover/tv")
    fun getTvShows(
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ): Single<TvShowsResponse>

    @GET("genre/tv/list")
    fun getGenresTv(@Query("api_key") api_key: String): Single<GenresResponse>

    @GET("genre/movie/list")
    fun getGenresMovie(@Query("api_key") api_key: String): Single<GenresResponse>

}