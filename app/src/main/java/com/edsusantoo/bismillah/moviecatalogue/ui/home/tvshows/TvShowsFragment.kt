package com.edsusantoo.bismillah.moviecatalogue.ui.home.tvshows


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
import com.edsusantoo.bismillah.moviecatalogue.data.local.other.MoviesModel
import com.edsusantoo.bismillah.moviecatalogue.data.utils.StatusResponse
import com.edsusantoo.bismillah.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_tv_shows.*


class TvShowsFragment : Fragment() {

    private lateinit var tvShowsViewModel: TvShowsViewModel

    companion object {
        fun newInstance(): Fragment {
            return TvShowsFragment()
        }

        private fun obtainViewModel(activity: FragmentActivity): TvShowsViewModel {
            val factory = ViewModelFactory.getInstance(activity.application)
            return ViewModelProviders.of(activity, factory).get(TvShowsViewModel::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_shows, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            tvShowsViewModel = obtainViewModel(activity!!)
            setup()

            observerMovies()
        }
    }

    private fun setup() {
        rv_tv_shows.layoutManager = LinearLayoutManager(context)
        rv_tv_shows.setHasFixedSize(true)
    }


    private fun observerMovies() {
        tvShowsViewModel.getTvShows()?.observe(this, Observer {
            if (it != null) {
                when (it.status) {
                    StatusResponse.LOADING -> {
                        progress_circular.visibility = View.VISIBLE
                    }
                    StatusResponse.ERROR -> {
                        progress_circular.visibility = View.GONE
                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    StatusResponse.SUCCESS -> {
                        progress_circular.visibility = View.GONE
                        onLoadMovieSuccess(it.data?.list)
                    }
                }
            }
        })
    }

    private fun onLoadMovieSuccess(data: List<MoviesModel>?) {
        if (data != null) {
            val adapter = TvShowsAdapter(context)
            adapter.addTvShows(data)
            rv_tv_shows.adapter = adapter
        }
    }
}
