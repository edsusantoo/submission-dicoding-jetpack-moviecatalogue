package com.edsusantoo.bismillah.moviecatalogue.ui.home.tvshows


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.edsusantoo.bismillah.moviecatalogue.R
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
        }
    }

    private fun setup() {

        val adapter = TvShowsAdapter(context)
        adapter.addTvShows(tvShowsViewModel.getTvShows())

        rv_tv_shows.layoutManager = LinearLayoutManager(context)
        rv_tv_shows.setHasFixedSize(true)
        rv_tv_shows.adapter = adapter

    }
}
