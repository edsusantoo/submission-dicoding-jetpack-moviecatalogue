package com.edsusantoo.bismillah.moviecatalogue.ui.home.movies


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.edsusantoo.bismillah.moviecatalogue.R
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment : Fragment() {

    private lateinit var moviesViewModel: MoviesViewModel

    companion object {
        fun newInstance(): Fragment {
            return MoviesFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            moviesViewModel = ViewModelProviders.of(activity!!).get(MoviesViewModel::class.java)

            setup()
        }
    }

    private fun setup() {

        val adapter = MoviesAdapter()
        adapter.addMovie(moviesViewModel.getMovies())

        rv_movies.layoutManager = LinearLayoutManager(context)
        rv_movies.setHasFixedSize(true)
        rv_movies.adapter = adapter

    }
}
