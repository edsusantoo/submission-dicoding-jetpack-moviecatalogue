package com.edsusantoo.bismillah.moviecatalogue.ui.home

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.edsusantoo.bismillah.moviecatalogue.R
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
        }

        if (fragment != null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit()
        }

        return@OnNavigationItemSelectedListener true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

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
}
