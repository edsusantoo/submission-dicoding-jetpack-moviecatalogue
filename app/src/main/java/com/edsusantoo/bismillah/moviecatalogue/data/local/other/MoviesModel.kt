package com.edsusantoo.bismillah.moviecatalogue.data.local.other

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviesModel(
    val title: String,
    val description: String,
    val rate: String,
    val genres: List<String>,
    val poster: String
) : Parcelable