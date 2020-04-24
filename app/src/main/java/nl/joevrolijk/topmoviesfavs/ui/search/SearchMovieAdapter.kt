package nl.joevrolijk.topmoviesfavs.ui.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_search_movie.view.*
import nl.joevrolijk.topmoviesfavs.R
import nl.joevrolijk.topmoviesfavs.model.Movie

class SearchMovieAdapter(private val movies: List<Movie>, private val onClick: (Movie) -> Unit) :
    RecyclerView.Adapter<SearchMovieAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_search_movie, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(movies[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onClick(movies[adapterPosition])
            }
        }

        fun bind(movie: Movie) {
            itemView.search_item_title.text = movie.title

            if (movie.overview.length < 110) {
                itemView.search_item_plot.text = movie.overview
            } else {
                itemView.search_item_plot.text = movie.overview.substring(0, 110) + " ..."
            }

            itemView.search_item_release.text = movie.releaseDate

            if (movie.getPosterImageUrl().isNotEmpty()) {
                Glide.with(context).load(movie.getPosterImageUrl())
                    .into(itemView.search_item_poster)
            }

        }
    }
}
