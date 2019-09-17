package com.edsusantoo.bismillah.moviecatalogue.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.edsusantoo.bismillah.moviecatalogue.R
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesFavoritesEntity
import com.edsusantoo.bismillah.moviecatalogue.data.local.other.MoviesModel
import com.edsusantoo.bismillah.moviecatalogue.utils.Constants
import com.edsusantoo.bismillah.moviecatalogue.utils.DataConverter
import com.edsusantoo.bismillah.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var detailViewModel: DetailViewModel
    private var favorite: MoviesFavoritesEntity? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        if (intent != null) {
            detailViewModel = obtainViewModel(this)

            getDataIntent()

            setDataIntent()

            onClick()

            observerErrorMessage()
            observerSuccessMessage()
            observerLoading()
            observerMovieIsFavorite()


            detailViewModel.getMovieIsFavorite(getDataIntent().title)

        }
    }

    private fun getDataIntent(): MoviesModel {
        return intent.getParcelableExtra(Constants.EXTRAS_MOVIE)
    }

    private fun setDataIntent() {
        tv_title.text = getDataIntent().title


        var dataGenres: String? = null
        for (i in 0 until getDataIntent().genres.size) {
            dataGenres = if (dataGenres == null) {
                getDataIntent().genres[i]
            } else {
                dataGenres + ", " + getDataIntent().genres[i]
            }
        }
        tv_genre.text = dataGenres

        tv_rate.text = getDataIntent().rate

        tv_description.text = getDataIntent().description

        Glide.with(this)
            .load("${Constants.URL_POSTER}${getDataIntent().poster}")
            .into(img_poster)

    }

    private fun onClick() {

        val genres = DataConverter.listToJsonString(getDataIntent().genres)

        fab_favorite.setOnClickListener {
            when (getDataIntent().type) {
                Constants.MOVIE -> {
                    if (favorite != null && favorite?.movie_name == getDataIntent().title) {
                        fab_favorite.setImageResource(R.drawable.ic_favorite_border_dislike)
                        detailViewModel
                            .deleteMovie(
                                MoviesFavoritesEntity(
                                    getDataIntent().title,
                                    getDataIntent().description,
                                    genres,
                                    getDataIntent().rate,
                                    getDataIntent().type,
                                    getDataIntent().poster
                                )
                            )
                    } else {
                        fab_favorite.setImageResource(R.drawable.ic_favorite_like)
                        detailViewModel
                            .insertFavorite(
                                MoviesFavoritesEntity(
                                    getDataIntent().title,
                                    getDataIntent().description,
                                    genres,
                                    getDataIntent().rate,
                                    getDataIntent().type,
                                    getDataIntent().poster
                                )
                            )
                    }
                }
                Constants.TVSHOW -> {
                    if (favorite != null && favorite?.movie_name == getDataIntent().title) {
                        fab_favorite.setImageResource(R.drawable.ic_favorite_border_dislike)
                        detailViewModel
                            .deleteMovie(
                                MoviesFavoritesEntity(
                                    getDataIntent().title,
                                    getDataIntent().description,
                                    genres,
                                    getDataIntent().rate,
                                    getDataIntent().type,
                                    getDataIntent().poster
                                )
                            )
                    } else {
                        fab_favorite.setImageResource(R.drawable.ic_favorite_like)
                        detailViewModel
                            .insertFavorite(
                                MoviesFavoritesEntity(
                                    getDataIntent().title,
                                    getDataIntent().description,
                                    genres,
                                    getDataIntent().rate,
                                    getDataIntent().type,
                                    getDataIntent().poster
                                )
                            )
                    }
                }
            }

        }
    }


    private fun observerLoading() {
        detailViewModel.isLoading().observe(this, Observer {
            if (it) {

            } else {

            }
        })
    }

    private fun observerErrorMessage() {
        detailViewModel.errorMessage().observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }

    private fun observerSuccessMessage() {
        detailViewModel.successMessage().observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }

    private fun observerMovieIsFavorite() {
        detailViewModel.getMovieIsFavorite().observe(this, Observer {
            favorite = it
            if (it.movie_name == getDataIntent().title) {
                fab_favorite.setImageResource(R.drawable.ic_favorite_like)
            }
        })
    }

    private fun obtainViewModel(activity: AppCompatActivity): DetailViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(DetailViewModel::class.java)
    }

}
