package com.edsusantoo.bismillah.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edsusantoo.bismillah.moviecatalogue.data.MovieCatalogueRepository
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesFavoritesEntity
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.MaybeObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class DetailViewModel(
    private val movieCatalogueRepository: MovieCatalogueRepository?
) : ViewModel() {


    private val movieIsFavorite = MutableLiveData<MoviesFavoritesEntity>()
    private val mErrorMessage = MutableLiveData<String>()
    private val successMessage = MutableLiveData<String>()
    private val isLoading = MutableLiveData<Boolean>()

    fun getMovieIsFavorite(): LiveData<MoviesFavoritesEntity> {
        return movieIsFavorite
    }

    fun errorMessage(): LiveData<String> {
        return mErrorMessage
    }

    fun isLoading(): LiveData<Boolean> {
        return isLoading
    }

    fun successMessage(): LiveData<String> {
        return successMessage
    }

    fun getMovieIsFavorite(movieName: String) {
        movieCatalogueRepository?.getMoviesIfFavorites(movieName)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : MaybeObserver<MoviesFavoritesEntity> {
                override fun onSuccess(t: MoviesFavoritesEntity) {
                    movieIsFavorite.value = t
                }

                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    mErrorMessage.value = e.message
                }

            })
    }


    fun insertFavorite(moviesFavoritesEntity: MoviesFavoritesEntity) {
        Completable.fromAction {
            movieCatalogueRepository?.insertMoviesFavorites(moviesFavoritesEntity)
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : CompletableObserver {
                override fun onComplete() {
                    successMessage.value = "Berhasil menambahkan film favorite"
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {

                    mErrorMessage.value = e.message
                }

            })
    }


    fun deleteMovie(moviesFavoritesEntity: MoviesFavoritesEntity) {
        Completable.fromAction {
            movieCatalogueRepository?.deleteMoviesFavorites(moviesFavoritesEntity)
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : CompletableObserver {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onComplete() {
                    successMessage.value = "Movie Berhasil Dihapus"
                }

                override fun onError(e: Throwable) {
                    mErrorMessage.value = e.message
                }
            })
    }

    override fun onCleared() {
        super.onCleared()
        movieCatalogueRepository?.isCompositeDisposable()?.dispose()
    }
}