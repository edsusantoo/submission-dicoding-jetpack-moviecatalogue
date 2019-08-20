package com.edsusantoo.bismillah.moviecatalogue.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviesModel(
        val title: String,
        val description: String,
        val rate: String,
        val genres: List<String>,
        @DrawableRes val poster: Int
) : Parcelable