package com.edsusantoo.bismillah.moviecatalogue.ui.home.tvshows

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edsusantoo.bismillah.moviecatalogue.R
import com.edsusantoo.bismillah.moviecatalogue.data.local.other.MoviesModel
import com.edsusantoo.bismillah.moviecatalogue.ui.detail.DetailActivity
import com.edsusantoo.bismillah.moviecatalogue.utils.Constants
import kotlinx.android.synthetic.main.item_movies.view.*

class TvShowsAdapter(private val context: Context?) : RecyclerView.Adapter<TvShowsAdapter.TvShowsViewHolder>() {

    private lateinit var data: List<MoviesModel>

    fun addTvShows(movie: List<MoviesModel>) {
        data = movie
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        holder.bind(data[position], context)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(
                Constants.EXTRAS_MOVIE, MoviesModel(
                    data[position].id,
                    data[position].title,
                    data[position].description,
                    data[position].rate,
                    data[position].genres,
                    data[position].poster,
                    Constants.TVSHOW
                )
            )

            context?.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder {
        return TvShowsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false))
    }


    class TvShowsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvTitle: TextView = view.tv_title
        private val tvGenre: TextView = view.tv_genre
        private val tvRate: TextView = view.tv_rate
        private val imgPoster: ImageView = view.img_poster

        fun bind(movie: MoviesModel, context: Context?) {
            tvTitle.text = movie.title
            var dataGenres: String? = null
            for (i in 0 until movie.genres.size) {
                dataGenres = if (dataGenres == null) {
                    movie.genres[i]
                } else {
                    dataGenres + ", " + movie.genres[i]
                }
            }
            tvGenre.text = dataGenres
            tvRate.text = movie.rate
            Glide.with(context!!)
                .load("${Constants.URL_POSTER}${movie.poster}")
                .error(R.drawable.ic_broken_image)
                .into(imgPoster)
        }
    }


}