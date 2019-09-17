package com.edsusantoo.bismillah.moviecatalogue.ui.home.favorites.movies


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.edsusantoo.bismillah.moviecatalogue.R
import com.edsusantoo.bismillah.moviecatalogue.ui.home.favorites.adapter.FavoritesAdapter
import com.edsusantoo.bismillah.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_movies_favorite.*


class MoviesFavoriteFragment : Fragment() {

    private lateinit var viewModel: MoviesFavoriteViewModel

    private lateinit var adapterFavorite: FavoritesAdapter

    companion object {
        fun getInstance(): Fragment {
            return MoviesFavoriteFragment()
        }

        private fun obtainViewModel(activity: FragmentActivity): MoviesFavoriteViewModel {
            val factory = ViewModelFactory.getInstance(activity.application)
            return ViewModelProviders.of(activity, factory).get(MoviesFavoriteViewModel::class.java)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            viewModel = obtainViewModel(activity!!)

            setup()

            observerIsLoading()
            observerErrorMessage()
            observerMoviesFavorites()


        }
    }

    private fun observerIsLoading() {
        viewModel.isLoading().observe(this, Observer {
            if (it) {
            } else {
            }
        })
    }

    private fun observerErrorMessage() {
        viewModel.getErrorMessage().observe(this, Observer {
            Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
        })
    }

    private fun observerMoviesFavorites() {
        viewModel.getAllMoviesFavorites().observe(this, Observer {
            if (it != null) {
                adapterFavorite.submitList(it)
            }
        })
    }


    private fun setup() {
        adapterFavorite = FavoritesAdapter(activity)
        rv_favorites_movie.layoutManager = LinearLayoutManager(activity)
        rv_favorites_movie.adapter = adapterFavorite
    }
}
