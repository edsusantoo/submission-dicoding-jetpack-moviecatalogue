package com.edsusantoo.bismillah.moviecatalogue.ui.home.movies


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
import com.edsusantoo.bismillah.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_movies.*

//TODO:progressbar masih keliatan ketika dipanggil kembali, saat live data ada isinya
class MoviesFragment : Fragment() {

    private lateinit var moviesViewModel: MoviesViewModel

    companion object {
        fun newInstance(): Fragment {
            return MoviesFragment()
        }

        private fun obtainViewModel(activity: FragmentActivity): MoviesViewModel {
            val factory = ViewModelFactory.getInstance(activity.application)
            return ViewModelProviders.of(activity, factory).get(MoviesViewModel::class.java)
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
            moviesViewModel = obtainViewModel(activity!!)
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
