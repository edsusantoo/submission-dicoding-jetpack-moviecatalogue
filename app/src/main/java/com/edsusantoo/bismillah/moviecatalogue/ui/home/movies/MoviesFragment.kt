package com.edsusantoo.bismillah.moviecatalogue.ui.home.movies


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
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment : Fragment() {

    private lateinit var moviesViewModel: MoviesViewModel

    companion object {
        fun newInstance(): Fragment {
            return MoviesFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            moviesViewModel = ViewModelProviders.of(activity!!).get(MoviesViewModel::class.java)
            setup()

            observerLoading()
            observerMovies()
            observerErrorMessage()
        }
    }

    private fun setup() {
        rv_movies.layoutManager = LinearLayoutManager(context)
        rv_movies.setHasFixedSize(true)

    }

    private fun observerLoading() {
        moviesViewModel.isLoading().observe(this, Observer {
            if (it) {
                progress_circular.visibility = View.VISIBLE
            } else {
                progress_circular.visibility = View.GONE
            }
        })
    }

    private fun observerErrorMessage() {
        moviesViewModel.getErrorMessage().observe(this, Observer {
            Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
        })
    }

    private fun observerMovies() {
        moviesViewModel.getMovies().observe(this, Observer {
            onLoadMovieSucces(it.list)
        })
    }

    private fun onLoadMovieSucces(data: List<MoviesModel>) {
        val adapter = MoviesAdapter(context)
        adapter.addMovie(data)
        rv_movies.adapter = adapter
    }
}
