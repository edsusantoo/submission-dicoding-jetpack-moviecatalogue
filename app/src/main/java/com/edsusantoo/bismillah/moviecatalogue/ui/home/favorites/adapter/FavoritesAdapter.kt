package com.edsusantoo.bismillah.moviecatalogue.ui.home.favorites.adapter

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
import com.edsusantoo.bismillah.moviecatalogue.data.local.db.model.MoviesEntity
import com.edsusantoo.bismillah.moviecatalogue.data.local.other.MoviesModel
import com.edsusantoo.bismillah.moviecatalogue.ui.detail.DetailActivity
import com.edsusantoo.bismillah.moviecatalogue.utils.Constants
import com.edsusantoo.bismillah.moviecatalogue.utils.DataConverter
import kotlinx.android.synthetic.main.item_movies.view.*


class FavoritesAdapter(
    private val data: List<MoviesEntity>,
    private val context: Context?
) : RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        return FavoritesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {

        holder.bind(data[position], context)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(
                Constants.EXTRAS_MOVIE, MoviesModel(
                    data[position].movieId,
                    data[position].movie_name,
                    data[position].description,
                    data[position].rate,
                    holder.genres,
                    data[position].image,
                    Constants.MOVIE
                )
            )

            context?.startActivity(intent)
        }
    }

    class FavoritesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvTitle: TextView = view.tv_title
        private val tvGenre: TextView = view.tv_genre
        private val tvRate: TextView = view.tv_rate
        private val imgPoster: ImageView = view.img_poster


        var genres: List<String> = ArrayList()

        fun bind(movie: MoviesEntity, context: Context?) {
            genres = DataConverter.jsonStringToList(movie.genre)
            tvTitle.text = movie.movie_name
            var dataGenres: String? = null
            for (i in 0 until movie.genre.length) {
                dataGenres = (if (dataGenres == null) {
                    movie.genre[i]
                } else {
                    dataGenres + ", " + movie.genre[i]
                }).toString()
            }
            tvGenre.text = dataGenres
            tvRate.text = movie.rate
            Glide.with(context!!)
                .load("${Constants.URL_POSTER}${movie.image}")
                .into(imgPoster)

        }
    }


}