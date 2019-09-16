package com.edsusantoo.bismillah.moviecatalogue.ui.home.favorites.movies


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edsusantoo.bismillah.moviecatalogue.R


class MoviesFavoriteFragment : Fragment() {

    companion object {
        fun getInstance(): Fragment {
            return MoviesFavoriteFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_favorite, container, false)
    }


}
