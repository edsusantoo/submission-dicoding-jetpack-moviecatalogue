package com.edsusantoo.bismillah.moviecatalogue.data.remote

import com.edsusantoo.bismillah.moviecatalogue.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RemoteConfig {
    companion object {
        private fun getRetrofit(): Retrofit {
            val gsonBuilder: Gson = GsonBuilder().setLenient().create()
            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(initHttpClient())
                .build()
        }

        private fun initHttpClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()
        }

        fun getRemoteApiStore(): RemoteApiStore {
            return getRetrofit().create(RemoteApiStore::class.java)
        }

    }

}