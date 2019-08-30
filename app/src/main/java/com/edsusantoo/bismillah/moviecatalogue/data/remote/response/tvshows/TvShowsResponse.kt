package com.edsusantoo.bismillah.moviecatalogue.data.remote.response.tvshows


import com.google.gson.annotations.SerializedName

data class TvShowsResponse(
    val page: Int,
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)