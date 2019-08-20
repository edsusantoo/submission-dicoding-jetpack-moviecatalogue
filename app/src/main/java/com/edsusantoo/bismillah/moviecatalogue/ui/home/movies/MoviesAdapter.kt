package com.edsusantoo.bismillah.moviecatalogue.ui.home.movies

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.edsusantoo.bismillah.moviecatalogue.R
import com.edsusantoo.bismillah.moviecatalogue.data.MoviesModel
import com.edsusantoo.bismillah.moviecatalogue.ui.detail.DetailActivity
import com.edsusantoo.bismillah.moviecatalogue.utils.Constans
import kotlinx.android.synthetic.main.item_movies.view.*


class MoviesAdapter(private val context: Context?) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private lateinit var data: List<MoviesModel>

    fun addMovie(movie: List<MoviesModel>) {
        data = movie
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(data[position], context)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(
                    Constans.EXTRAS_MOVIE, MoviesModel(
                    data[position].title,
                    data[position].description,
                    data[position].rate,
                    data[position].genres,
                    data[position].poster
            )
            )

            context?.startActivity(intent)
        }
    }

    class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvTitle: TextView = view.tv_title
        private val tvGenre: TextView = view.tv_genre
        private val tvRate: TextView = view.tv_rate
        private val imgPoster: ImageView = view.img_poster
        private val cvMovie: CardView = view.cv_movie
        private var backgroundColor: Int = 0

        fun bind(movie: MoviesModel, context: Context?) {
            tvTitle.text = movie.title
            var dataGenres: String? = null
            for (i in 0 until movie.genres.size) {
                if (dataGenres == null) {
                    dataGenres = movie.genres[i]
                } else {
                    dataGenres = dataGenres + ", " + movie.genres[i]
                }
            }
            tvGenre.text = dataGenres
            tvRate.text = movie.rate
            imgPoster.setImageResource(movie.poster)
        }
    }


}