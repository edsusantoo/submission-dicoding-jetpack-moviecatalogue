package com.edsusantoo.bismillah.moviecatalogue.ui.home

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.edsusantoo.bismillah.moviecatalogue.R
import com.edsusantoo.bismillah.moviecatalogue.ui.home.favorites.FavoriteFragment
import com.edsusantoo.bismillah.moviecatalogue.ui.home.movies.MoviesFragment
import com.edsusantoo.bismillah.moviecatalogue.ui.home.tvshows.TvShowsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val SELECTED_MENU = "selected_menu"

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var fragment: Fragment? = null
        when (item.itemId) {
            R.id.navigation_movies -> {
                fragment = MoviesFragment.newInstance()
            }
            R.id.navigation_tv_shows -> {
                fragment = TvShowsFragment.newInstance()
            }
            R.id.navigation_favorite -> {
                fragment = FavoriteFragment.getInstance()
            }
        }

        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.frame_container, fragment)
                .commit()
        }

        return@OnNavigationItemSelectedListener true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        nav_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        if (savedInstanceState != null) {
            savedInstanceState.getInt(SELECTED_MENU)
        } else {
            nav_view.selectedItemId = R.id.navigation_movies
        }
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putInt(SELECTED_MENU, nav_view.selectedItemId)
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}
