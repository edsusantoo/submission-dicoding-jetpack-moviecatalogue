package com.edsusantoo.bismillah.moviecatalogue.ui.home.tvshows


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.edsusantoo.bismillah.moviecatalogue.R
import com.edsusantoo.bismillah.moviecatalogue.data.local.MoviesModel
import kotlinx.android.synthetic.main.fragment_tv_shows.*


class TvShowsFragment : Fragment() {

    private lateinit var tvShowsViewModel: TvShowsViewModel

    companion object {
        fun newInstance(): Fragment {
            return TvShowsFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_shows, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            tvShowsViewModel = ViewModelProviders.of(activity!!).get(TvShowsViewModel::class.java)
            setup()
            observerLoading()
            observerMovies()
            observerErrorMessage()
        }
    }

    private fun setup() {
        rv_tv_shows.layoutManager = LinearLayoutManager(context)
        rv_tv_shows.setHasFixedSize(true)
    }

    private fun observerLoading() {
        tvShowsViewModel.isLoading().observe(this, Observer {
            if (it) {
                progress_circular.visibility = View.VISIBLE
            } else {
                progress_circular.visibility = View.GONE
            }
        })
    }

    private fun observerErrorMessage() {
        tvShowsViewModel.getErrorMessage().observe(this, Observer {
            Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
        })
    }

    private fun observerMovies() {
        tvShowsViewModel.getTvShows().observe(this, Observer {
            onLoadMovieSuccess(it.list)
        })
    }

    private fun onLoadMovieSuccess(data: List<MoviesModel>) {
        val adapter = TvShowsAdapter(context)
        adapter.addTvShows(data)
        rv_tv_shows.adapter = adapter
    }
}
