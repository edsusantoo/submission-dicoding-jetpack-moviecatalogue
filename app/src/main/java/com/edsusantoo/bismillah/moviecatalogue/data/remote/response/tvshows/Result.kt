package com.edsusantoo.bismillah.moviecatalogue.data.remote.response.tvshows


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("first_air_date")
    val firstAirDate: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    val id: Int,
    val name: String,
    @SerializedName("origin_country")
    val originCountry: List<String>,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_name")
    val originalName: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String? = null,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)