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
import com.edsusantoo.bismillah.moviecatalogue.data.utils.StatusResponse
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

            observerMovieIsFavorite()
        }

        fab_back.setOnClickListener {
            finish()
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
            .fitCenter()
            .into(img_poster)

    }

    private fun onClick() {

        val genres = DataConverter.listToJsonString(getDataIntent().genres)
        fab_favorite.setOnClickListener {
            when (getDataIntent().type) {
                Constants.MOVIE -> {
                    if (favorite != null && favorite?.movie_name == getDataIntent().title) {
                        fab_favorite.setImageResource(R.drawable.ic_favorite_border_dislike)
                        observerDeleteFavorite(
                                MoviesFavoritesEntity(
                                    getDataIntent().id,
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
                        observerInsertFavorite(
                                MoviesFavoritesEntity(
                                    getDataIntent().id,
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
                        observerDeleteFavorite(
                                MoviesFavoritesEntity(
                                    getDataIntent().id,
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
                        observerInsertFavorite(
                                MoviesFavoritesEntity(
                                    getDataIntent().id,
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

    private fun observerInsertFavorite(moviesFavoritesEntity: MoviesFavoritesEntity) {
        detailViewModel.insertFavorite(moviesFavoritesEntity).observe(this, Observer {
            when (it.status) {
                StatusResponse.LOADING -> {

                }
                StatusResponse.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                StatusResponse.SUCCESS -> {
                    Toast.makeText(this, it.data?.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun observerDeleteFavorite(moviesFavoritesEntity: MoviesFavoritesEntity) {
        detailViewModel.deleteMovie(moviesFavoritesEntity).observe(this, Observer {
            when (it.status) {
                StatusResponse.LOADING -> {

                }
                StatusResponse.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                StatusResponse.SUCCESS -> {
                    Toast.makeText(this, it.data?.message, Toast.LENGTH_LONG).show()
                }
            }
        })

    }


    private fun observerMovieIsFavorite() {
        detailViewModel.getMovieIsFavorite(getDataIntent().title).observe(this, Observer {
            when (it.status) {
                StatusResponse.LOADING -> {

                }
                StatusResponse.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                StatusResponse.SUCCESS -> {
                    favorite = it.data
                    if (it.data?.movie_name == getDataIntent().title) {
                        fab_favorite.setImageResource(R.drawable.ic_favorite_like)
                    }
                }


            }
        })
    }

    private fun obtainViewModel(activity: AppCompatActivity): DetailViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(DetailViewModel::class.java)
    }

}
