package com.edsusantoo.bismillah.moviecatalogue.ui.home.favorites.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edsusantoo.bismillah.moviecatalogue.data.MovieCatalogueRepository
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.FavoritesEntity
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesEntity
import io.reactivex.MaybeObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MoviesFavoriteViewModel(
    private val movieCatalogueRepository: MovieCatalogueRepository?
) : ViewModel() {


    private val dataFavorites = MutableLiveData<List<FavoritesEntity>>()
    private val dataMovies = MutableLiveData<List<MoviesEntity>>()
    private val errorMassage = MutableLiveData<String>()
    private val isLoading = MutableLiveData<Boolean>()

    fun getMovieIsFavorite() {
        movieCatalogueRepository
            ?.getAllFavorites()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : MaybeObserver<List<FavoritesEntity>> {
                override fun onSuccess(t: List<FavoritesEntity>) {
                    dataFavorites.value = t
                }

                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    errorMassage.value = e.message
                }

            })
    }

    fun getDetailMovie(movieId: Int, type: String) {
        movieCatalogueRepository
            ?.getMoviesWhereType(movieId, type)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : MaybeObserver<List<MoviesEntity>> {
                override fun onSuccess(t: List<MoviesEntity>) {
                    dataMovies.value = t
                }

                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    errorMassage.value = e.message
                }

            })

    }

    fun getDataMovieIfFavorite(): LiveData<List<FavoritesEntity>> {
        return dataFavorites
    }

    fun getDataDetailMovies(): LiveData<List<MoviesEntity>> {
        return dataMovies
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