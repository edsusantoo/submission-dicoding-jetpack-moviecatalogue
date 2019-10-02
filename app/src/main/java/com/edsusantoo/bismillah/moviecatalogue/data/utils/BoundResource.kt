package com.edsusantoo.bismillah.moviecatalogue.data.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

abstract class BoundResource<ResultType> {
    private val result = MediatorLiveData<Resource<ResultType>>()

    private fun onFetchFailed() {}

    protected abstract fun createCall(): LiveData<Resource<ResultType>>


    init {
        val apiResponse = this.createCall()
        result.value = Resource.loading(null)
        result.addSource(apiResponse) {
            result.removeSource(apiResponse)
            when (it.status) {
                StatusResponse.SUCCESS -> {
                    result.value = Resource.success(it.data)
                }
                StatusResponse.ERROR -> {
                    onFetchFailed()
                    result.value = Resource.error(it.message)
                }
                else -> {
                }
            }
        }
    }

    fun asLiveData(): LiveData<Resource<ResultType>> {
        return result
    }
}