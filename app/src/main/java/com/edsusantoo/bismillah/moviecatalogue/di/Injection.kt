package com.edsusantoo.bismillah.moviecatalogue.di

import android.app.Application
import com.edsusantoo.bismillah.moviecatalogue.data.MovieCatalogueRepository
import com.edsusantoo.bismillah.moviecatalogue.data.local.LocalRepository
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.MovieCatalogueDatabase
import com.edsusantoo.bismillah.moviecatalogue.data.remote.RemoteRepository

class Injection {
    companion object {
        fun provideRepository(application: Application): MovieCatalogueRepository? {
            val remoteRepository = RemoteRepository()
            val database = MovieCatalogueDatabase.getInstance(application.applicationContext)
            val localRepository = LocalRepository.getInstance(
                database.moviesDao(),
                database.favoritesDao()
            )

            return MovieCatalogueRepository.getInstance(localRepository, remoteRepository)
        }
    }
}