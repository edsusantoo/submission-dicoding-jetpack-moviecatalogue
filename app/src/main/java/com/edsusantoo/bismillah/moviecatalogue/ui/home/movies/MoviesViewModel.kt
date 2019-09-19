package com.edsusantoo.bismillah.moviecatalogue.ui.home.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edsusantoo.bismillah.moviecatalogue.data.MovieCatalogueRepository
import com.edsusantoo.bismillah.moviecatalogue.data.local.other.MoviesCatalogueModel
import com.edsusantoo.bismillah.moviecatalogue.data.local.other.MoviesModel
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.genres.GenresResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.movie.MoviesResponse
import com.edsusantoo.bismillah.moviecatalogue.data.remote.response.movie.Result
import com.edsusantoo.bismillah.moviecatalogue.utils.Constants
import com.edsusantoo.bismillah.moviecatalogue.utils.EspressoIdlingResource
import com.edsusantoo.bismillah.moviecatalogue.utils.MovieCatalogueFunction
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

class MoviesViewModel(
    private val movieCatalogueRepository: MovieCatalogueRepository?
) : ViewModel() {

    private val dataMovie = MutableLiveData<MoviesCatalogueModel>()
    private val errorMassage = MutableLiveData<String>()
    private val isLoading = MutableLiveData<Boolean>()

    fun getMovies(): LiveData<MoviesCatalogueModel> {

        EspressoIdlingResource.increment()

        isLoading.postValue(true)

        movieCatalogueRepository?.isCompositeDisposable()?.add(
            Single.zip(
                movieCatalogueRepository.getMovies("en-US"),
                movieCatalogueRepository.getGenresMovies(),
                BiFunction<MoviesResponse, GenresResponse, Unit>
                { movies, genres -> setMoviesAndGenres(movies, genres) }
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        isLoading.postValue(false)
                        if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                            EspressoIdlingResource.decrement() // Set app as idle.
                        }
                    },
                    { errorMessage ->
                        isLoading.postValue(false)
                        errorMassage.postValue(errorMessage.message)
                    }
                ))

        return dataMovie
    }


    private fun setMoviesAndGenres(moviesResponse: MoviesResponse, genresResponse: GenresResponse) {
        val movies = ArrayList<MoviesModel>()
        for (i in 0 until moviesResponse.results.size) {
            movies.add(
                MoviesModel(
                    moviesResponse.results[i].id,
                    moviesResponse.results[i].title,
                    moviesResponse.results[i].overview,
                    MovieCatalogueFunction.convertRate(moviesResponse.results[i].voteAverage) + "%",
                    getGenres(moviesResponse.results[i], genresResponse),
                    moviesResponse.results[i].posterPath,
                    Constants.MOVIE

                )
            )
        }

        dataMovie.postValue(MoviesCatalogueModel(movies))

    }

    private fun getGenres(movieResult: Result, genresResponse: GenresResponse): ArrayList<String> {
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

    fun getErrorMessage(): LiveData<String> {
        return errorMassage
    }

    fun isLoading(): LiveData<Boolean> {
        return isLoading
    }

    override fun onCleared() {
        super.onCleared()
        movieCatalogueRepository?.isCompositeDisposable()?.dispose()
    }
}