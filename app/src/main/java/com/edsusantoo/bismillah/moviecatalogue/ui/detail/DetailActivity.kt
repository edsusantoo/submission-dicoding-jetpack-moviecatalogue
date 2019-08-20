package com.edsusantoo.bismillah.moviecatalogue.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.edsusantoo.bismillah.moviecatalogue.R
import com.edsusantoo.bismillah.moviecatalogue.utils.Constans
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
        detailViewModel.setMovieDetail(intent.getParcelableExtra(Constans.EXTRAS_MOVIE))
    }

    private fun setDataIntent() {
        tv_title.text = detailViewModel.getMovieDetail()?.title


        var dataGenres: String? = null
        for (i in 0 until detailViewModel.getMovieDetail()?.genres!!.size) {
            if (dataGenres == null) {
                dataGenres = detailViewModel.getMovieDetail()!!.genres[i]
            } else {
                dataGenres = dataGenres + ", " + detailViewModel.getMovieDetail()!!.genres[i]
            }
        }
        tv_genre.text = dataGenres

        tv_rate.text = detailViewModel.getMovieDetail()?.rate

        tv_description.text = detailViewModel.getMovieDetail()?.description

        img_poster.setImageResource(detailViewModel.getMovieDetail()!!.poster)

    }
}
