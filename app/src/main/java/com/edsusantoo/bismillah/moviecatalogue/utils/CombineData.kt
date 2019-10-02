package com.edsusantoo.bismillah.moviecatalogue.utils

import androidx.lifecycle.MutableLiveData
import com.edsusantoo.bismillah.moviecatalogue.data.local.other.MoviesCatalogueModel
import com.edsusantoo.bismillah.moviecatalogue.data.local.other.MoviesModel
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.genres.GenresResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.movie.MoviesResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.movie.Result
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.tvshows.TvShowsResponse

class CombineData {
    companion object {
        val movies_genres = MutableLiveData<MoviesCatalogueModel>()
        fun setMoviesAndGenres(moviesResponse: MoviesResponse, genresResponse: GenresResponse) {
            val movies = ArrayList<MoviesModel>()
            for (i in 0 until moviesResponse.results.size) {
                movies.add(
                    MoviesModel(
                        moviesResponse.results[i].id,
                        moviesResponse.results[i].title,
                        moviesResponse.results[i].overview,
                        MovieCatalogueFunction.convertRate(moviesResponse.results[i].voteAverage) + "%",
                        getGenresMovies(moviesResponse.results[i], genresResponse),
                        moviesResponse.results[i].posterPath,
                        Constants.MOVIE

                    )
                )
            }

            movies_genres.postValue(MoviesCatalogueModel(movies))
        }

        fun setTvShowsAndGenres(tvShowsResponse: TvShowsResponse, genresResponse: GenresResponse) {
            val movies = ArrayList<MoviesModel>()
            var poster: String?
            for (i in 0 until tvShowsResponse.results.size) {
                poster = if (tvShowsResponse.results[i].posterPath == null) {
                    "https://"
                } else {
                    tvShowsResponse.results[i].posterPath
                }
                movies.add(
                    MoviesModel(
                        tvShowsResponse.results[i].id,
                        tvShowsResponse.results[i].name,
                        tvShowsResponse.results[i].overview,
                        MovieCatalogueFunction.convertRate(tvShowsResponse.results[i].voteAverage) + "%",
                        getGenresTvShows(tvShowsResponse.results[i], genresResponse),
                        poster!!,
                        Constants.MOVIE

                    )
                )
            }

            movies_genres.postValue(MoviesCatalogueModel(movies))
        }

        private fun getGenresMovies(movieResult: Result, genresResponse: GenresResponse): ArrayList<String> {
            val genresName = ArrayList<String>()
            for (j in 0 until movieResult.genreIds.size) {
                for (k in 0 until genresResponse.genres.size) {
                    if (movieResult.genreIds[j] == genresResponse.genres[k].id) {
                        genresName.add(genresResponse.genres[k].name)
                    }
                }
            }
            return genresName
        }

        private fun getGenresTvShows(
            movieResult: com.edsusantoo.bismillah.moviecatalogue.data.remote.response.tvshows.Result,
            genresResponse: GenresResponse
        ): ArrayList<String> {
            val genresName = ArrayList<String>()
            for (j in 0 until movieResult.genreIds.size) {
                for (k in 0 until genresResponse.genres.size) {
                    if (movieResult.genreIds[j] == genresResponse.genres[k].id) {
                        genresName.add(genresResponse.genres[k].name)
                    }
                }
            }
            return genresName
        }
    }
}