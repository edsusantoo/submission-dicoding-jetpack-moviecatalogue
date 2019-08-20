package com.edsusantoo.bismillah.moviecatalogue.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.edsusantoo.bismillah.moviecatalogue.R
import com.edsusantoo.bismillah.moviecatalogue.data.MoviesModel
import com.edsusantoo.bismillah.moviecatalogue.utils.Constans
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if (intent != null) {
            getDataIntent()

            setDataIntent()
        }
    }

    private fun getDataIntent(): MoviesModel {
        return intent.getParcelableExtra(Constans.EXTRAS_MOVIE)
    }

    private fun setDataIntent() {
        tv_title.text = getDataIntent().title


        var dataGenres: String? = null
        for (i in 0 until getDataIntent().genres.size) {
            if (dataGenres == null) {
                dataGenres = getDataIntent().genres[i]
            } else {
                dataGenres = dataGenres + ", " + getDataIntent().genres[i]
            }
        }
        tv_genre.text = dataGenres

        tv_rate.text = getDataIntent().rate

        tv_description.text = getDataIntent().description

        img_poster.setImageResource(getDataIntent().poster)

    }
}
