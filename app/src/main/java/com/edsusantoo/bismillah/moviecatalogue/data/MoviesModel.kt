package com.edsusantoo.bismillah.moviecatalogue.data

import androidx.annotation.DrawableRes

data class MoviesModel(
        val title: String,
        val description: String,
        val rate: String,
        val genres: List<String>,
        @DrawableRes val poster: Int
)