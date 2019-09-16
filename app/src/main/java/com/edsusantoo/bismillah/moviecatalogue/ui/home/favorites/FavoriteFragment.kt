package com.edsusantoo.bismillah.moviecatalogue.ui.home.favorites


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edsusantoo.bismillah.moviecatalogue.R
import com.edsusantoo.bismillah.moviecatalogue.ui.home.favorites.movies.MoviesFavoriteFragment
import com.edsusantoo.bismillah.moviecatalogue.ui.home.favorites.tvshows.TvShowsFavoriteFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_favorite.*


class FavoriteFragment : Fragment() {

    companion object {
        fun getInstance(): Fragment {
            return FavoriteFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setup()

        //for tab first show
        showFragment(MoviesFavoriteFragment.getInstance())
    }

    private fun setup() {
        tab_favorite.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        showFragment(MoviesFavoriteFragment.getInstance())
                    }
                    1 -> {
                        showFragment(TvShowsFavoriteFragment.getInstance())
                    }
                }
            }

        })
    }


    private fun showFragment(fragment: Fragment) {
        childFragmentManager
            .beginTransaction()
            .replace(R.id.frame_container, fragment)
            .commit()
    }


}
