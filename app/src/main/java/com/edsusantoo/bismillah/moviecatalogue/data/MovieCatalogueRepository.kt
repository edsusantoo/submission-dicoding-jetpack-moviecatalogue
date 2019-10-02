package com.edsusantoo.bismillah.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.edsusantoo.bismillah.moviecatalogue.data.local.LocalRepository
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesFavoritesEntity
import com.edsusantoo.bismillah.moviecatalogue.data.local.other.MoviesCatalogueModel
import com.edsusantoo.bismillah.moviecatalogue.data.remote.RemoteRepository
import com.edsusantoo.bismillah.moviecatalogue.data.utils.BoundResource
import com.edsusantoo.bismillah.moviecatalogue.data.utils.MessageResponse
import com.edsusantoo.bismillah.moviecatalogue.data.utils.Resource
import io.reactivex.disposables.CompositeDisposable

class MovieCatalogueRepository(
    private val localRepository: LocalRepository?,
    private val remoteRepository: RemoteRepository
) : MovieCatalogueDataSource {
    companion object {
        private var INSTANCE: MovieCatalogueRepository? = null
        fun getInstance(
            localRepository: LocalRepository?,
            remoteRepository: RemoteRepository
        ): MovieCatalogueRepository? {
            if (INSTANCE == null) {
                INSTANCE = MovieCatalogueRepository(localRepository, remoteRepository)
            }

            return INSTANCE
        }
    }

    override fun isLocalCompositeDisposable(): CompositeDisposable {
        return localRepository!!.isLocalCompositeDisposable()
    }

    override fun isRemoteCompositeDisposable(): CompositeDisposable {
        return remoteRepository.isRemoteCompositeDisposable()
    }



    override fun getMovies(language: String): LiveData<Resource<MoviesCatalogueModel>> {
        return object : BoundResource<MoviesCatalogueModel>() {
            override fun createCall(): LiveData<Resource<MoviesCatalogueModel>> {
                return remoteRepository.getMovies(language)
            }
        }.asLiveData()
    }

    override fun getTvShows(language: String): LiveData<Resource<MoviesCatalogueModel>> {
        return object : BoundResource<MoviesCatalogueModel>() {
            override fun createCall(): LiveData<Resource<MoviesCatalogueModel>> {
                return remoteRepository.getTvShows(language)
            }

        }.asLiveData()
    }

    override fun insertMovies(moviesFavoritesEntity: MoviesFavoritesEntity): LiveData<Resource<MessageResponse>> {
        return object : BoundResource<MessageResponse>() {
            override fun createCall(): LiveData<Resource<MessageResponse>> {
                return localRepository!!.insertMoviesFavorites(moviesFavoritesEntity)
            }
        }.asLiveData()
    }


    override fun deleteMovies(moviesFavoritesEntity: MoviesFavoritesEntity): LiveData<Resource<MessageResponse>> {
        return object : BoundResource<MessageResponse>() {
            override fun createCall(): LiveData<Resource<MessageResponse>> {
                return localRepository!!.deleteMoviesFavorites(moviesFavoritesEntity)
            }

        }.asLiveData()
    }

    override fun getAllMoviesFavorites(type: String): DataSource.Factory<Int, MoviesFavoritesEntity>? {
        return localRepository?.getAllMoviesFavorites(type)
    }

    override fun getMoviesIfFavorites(movieName: String): LiveData<Resource<MoviesFavoritesEntity>> {
        return object : BoundResource<MoviesFavoritesEntity>() {
            override fun createCall(): LiveData<Resource<MoviesFavoritesEntity>> {
                return localRepository!!.getMoviesIfFavorites(movieName)
            }

        }.asLiveData()
    }

}