package com.edsusantoo.bismillah.moviecatalogue.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.edsusantoo.bismillah.moviecatalogue.R
import com.edsusantoo.bismillah.moviecatalogue.utils.Constants
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        if (intent != null) {
            detailViewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)

            getDataIntent()

            setDataIntent()
        }
    }

    private fun getDataIntent() {
        detailViewModel.setMovieDetail(intent.getParcelableExtra(Constants.EXTRAS_MOVIE))
    }

    private fun setDataIntent() {
        tv_title.text = detailViewModel.getMovieDetail()?.title


        var dataGenres: String? = null
        for (i in 0 until detailViewModel.getMovieDetail()?.genres!!.size) {
            dataGenres = if (dataGenres == null) {
                detailViewModel.getMovieDetail()!!.genres[i]
            } else {
                dataGenres + ", " + detailViewModel.getMovieDetail()!!.genres[i]
            }
        }
        tv_genre.text = dataGenres

        tv_rate.text = detailViewModel.getMovieDetail()?.rate

        tv_description.text = detailViewModel.getMovieDetail()?.description

        Glide.with(this)
            .load("${Constants.URL_POSTER}${detailViewModel.getMovieDetail()?.poster}")
            .into(img_poster)

    }
}
