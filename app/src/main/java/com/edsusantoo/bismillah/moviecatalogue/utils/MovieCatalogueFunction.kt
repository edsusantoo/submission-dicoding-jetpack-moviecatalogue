package com.edsusantoo.bismillah.moviecatalogue.utils

class MovieCatalogueFunction {
    companion object {
        fun convertRate(double: Double): String {
            return (double * 100 / 10).toInt().toString()
        }

    }

}