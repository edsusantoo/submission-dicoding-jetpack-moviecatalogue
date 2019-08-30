package com.edsusantoo.bismillah.moviecatalogue.ui.home.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edsusantoo.bismillah.moviecatalogue.BuildConfig
import com.edsusantoo.bismillah.moviecatalogue.data.MovieCatalogueRepository
import com.edsusantoo.bismillah.moviecatalogue.data.local.MoviesCatalogueModel
import com.edsusantoo.bismillah.moviecatalogue.data.local.MoviesModel
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.genres.GenresResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.tvshows.Result
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.tvshows.TvShowsResponse
import com.edsusantoo.bismillah.moviecatalogue.utils.MovieCatalogueFunction
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

class TvShowsViewModel : ViewModel() {
    private val movieCatalogueRepository = MovieCatalogueRepository()
    private val dataTvShows = MutableLiveData<MoviesCatalogueModel>()
    private val errorMassage = MutableLiveData<String>()
    private val isLoading = MutableLiveData<Boolean>()

    fun getTvShows(): LiveData<MoviesCatalogueModel> {

        isLoading.postValue(true)
        movieCatalogueRepository.isCompositeDisposable().add(
            Single.zip(
                movieCatalogueRepository.getTvShows(BuildConfig.API_KEY, "en-US"),
                movieCatalogueRepository.getGenresTvShows(BuildConfig.API_KEY),
                BiFunction<TvShowsResponse, GenresResponse, Unit> { tv_shows, genres ->
                    setTvShowsAndGenres(tv_shows, genres)
                }
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        isLoading.postValue(false)
                    },
                    { errorMessage ->
                        isLoading.postValue(false)
                        errorMassage.postValue(errorMessage.message)

                    }
                )

        )

        return dataTvShows
    }

    private fun setTvShowsAndGenres(tvShowsResponse: TvShowsResponse, genresResponse: GenresResponse) {
        val movies = ArrayList<MoviesModel>()
        for (i in 0 until tvShowsResponse.results.size) {
            movies.add(
                MoviesModel(
                    tvShowsResponse.results[i].name,
                    tvShowsResponse.results[i].overview,
                    MovieCatalogueFunction.convertRate(tvShowsResponse.results[i].voteAverage) + "%",
                    getGenres(tvShowsResponse.results[i], genresResponse),
                    tvShowsResponse.results[i].backdropPath
                )
            )
        }

        dataTvShows.postValue(MoviesCatalogueModel(movies))

    }

    private fun getGenres(tvShowsResult: Result, genresResponse: GenresResponse): ArrayList<String> {
        val genresName = ArrayList<String>()
        for (j in 0 until tvShowsResult.genreIds.size) {
            for (k in 0 until genresResponse.genres.size) {
                if (tvShowsResult.genreIds[j] == genresResponse.genres[k].id) {
                    genresName.add(genresResponse.genres[k].name)
                }
            }
        }
        return genresName
    }

    fun getErrorMessage(): LiveData<String> {
        return errorMassage
    }

    fun isLoading(): LiveData<Boolean> {
        return isLoading
    }

    override fun onCleared() {
        super.onCleared()
        movieCatalogueRepository.isCompositeDisposable().dispose()
    }
}
