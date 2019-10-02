package com.edsusantoo.bismillah.moviecatalogue.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.dao.MoviesFavoritesDao
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesFavoritesEntity
import com.edsusantoo.bismillah.moviecatalogue.data.utils.MessageResponse
import com.edsusantoo.bismillah.moviecatalogue.data.utils.Resource
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.MaybeObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class LocalRepository(
    private var moviesFavoritesDao: MoviesFavoritesDao
) {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    companion object {
        private var INSTANCE: LocalRepository? = null
        fun getInstance(
            moviesFavoritesDao: MoviesFavoritesDao
        ): LocalRepository? {
            if (INSTANCE == null) {
                INSTANCE = LocalRepository(moviesFavoritesDao)
            }

            return INSTANCE
        }
    }

    fun insertMoviesFavorites(moviesFavoritesEntity: MoviesFavoritesEntity): LiveData<Resource<MessageResponse>> {
        val data = MutableLiveData<Resource<MessageResponse>>()
        Completable.fromAction {
            moviesFavoritesDao.insert(moviesFavoritesEntity)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : CompletableObserver {
                override fun onComplete() {
                    data.value = Resource.success(MessageResponse("Berhasil menambahkan movies favorites"))
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    data.value = Resource.success(MessageResponse(e.message!!))
                }

            })

        return data
    }

    fun deleteMoviesFavorites(moviesFavoritesEntity: MoviesFavoritesEntity): LiveData<Resource<MessageResponse>> {
        val data = MutableLiveData<Resource<MessageResponse>>()
        Completable.fromAction {
            moviesFavoritesDao.delete(moviesFavoritesEntity)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : CompletableObserver {
                override fun onComplete() {
                    data.value = Resource.success(MessageResponse("Berhasil menghapus movies favorites"))
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    data.value = Resource.success(MessageResponse(e.message!!))
                }

            })

        return data
    }

    fun getMoviesIfFavorites(movieName: String): LiveData<Resource<MoviesFavoritesEntity>> {
        val data = MutableLiveData<Resource<MoviesFavoritesEntity>>()
        moviesFavoritesDao.getMoviesIfFavorites(movieName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MaybeObserver<MoviesFavoritesEntity> {
                override fun onSuccess(t: MoviesFavoritesEntity) {
                    data.value = Resource.success(t)
                }

                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    data.value = Resource.error(e.message)
                }

            })

        return data
    }

    fun getAllMoviesFavorites(type: String): DataSource.Factory<Int, MoviesFavoritesEntity> {
        return moviesFavoritesDao.getAllMoviesFavorites(type)
    }

    fun isCompositeDisposable(): CompositeDisposable {
        return compositeDisposable
    }

}