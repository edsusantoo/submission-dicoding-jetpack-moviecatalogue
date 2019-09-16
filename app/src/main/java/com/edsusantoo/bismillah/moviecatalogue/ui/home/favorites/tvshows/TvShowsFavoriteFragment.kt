package com.edsusantoo.bismillah.moviecatalogue.ui.home.favorites.tvshows


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edsusantoo.bismillah.moviecatalogue.R


class TvShowsFavoriteFragment : Fragment() {

    companion object {
        fun getInstance(): Fragment {
            return TvShowsFavoriteFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_shows_favorite, container, false)
    }


}
