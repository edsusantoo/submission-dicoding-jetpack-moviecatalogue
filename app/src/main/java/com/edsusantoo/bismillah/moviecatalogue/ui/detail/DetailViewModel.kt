package com.edsusantoo.bismillah.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edsusantoo.bismillah.moviecatalogue.data.MovieCatalogueRepository
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.FavoritesEntity
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesEntity
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.MaybeObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class DetailViewModel(
    private val movieCatalogueRepository: MovieCatalogueRepository?
) : ViewModel() {


    private val movieIsFavorite = MutableLiveData<FavoritesEntity>()
    private val mErrorMessage = MutableLiveData<String>()
    private val successMessage = MutableLiveData<String>()
    private val isLoading = MutableLiveData<Boolean>()

    fun getMovieIsFavorite(): LiveData<FavoritesEntity> {
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

    fun getMovieIsFavorite(movieId: Int): LiveData<FavoritesEntity> {
        movieCatalogueRepository?.getMovieIfFavorite(movieId)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : MaybeObserver<FavoritesEntity> {
                override fun onSuccess(t: FavoritesEntity) {
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

        return movieIsFavorite
    }


    fun insertFavorite(favoritesEntity: FavoritesEntity) {
        Completable.fromAction {
            movieCatalogueRepository?.insertFavorites(favoritesEntity)
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

    fun insertMovie(moviesEntity: MoviesEntity) {
        Completable.fromAction {
            movieCatalogueRepository?.insertMovies(moviesEntity)
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : CompletableObserver {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    mErrorMessage.value = e.message
                }

            })

    }


    fun deleteFavorite(favoritesEntity: FavoritesEntity) {
        Completable.fromAction {
            movieCatalogueRepository?.deleteFavorite(favoritesEntity)
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : CompletableObserver {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onComplete() {
                    successMessage.value = "Favorite Berhasil Dihapus"
                }

                override fun onError(e: Throwable) {
                    mErrorMessage.value = e.message
                }
            })
    }

    fun deleteMovie(moviesEntity: MoviesEntity) {
        Completable.fromAction {
            movieCatalogueRepository?.deleteMovie(moviesEntity)
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