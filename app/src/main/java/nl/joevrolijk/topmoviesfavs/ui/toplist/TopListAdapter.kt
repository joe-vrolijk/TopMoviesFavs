package nl.joevrolijk.topmoviesfavs.ui.toplist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.toplist_item.view.*
import nl.joevrolijk.topmoviesfavs.R
import nl.joevrolijk.topmoviesfavs.model.Movie

class TopListAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<TopListAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.toplist_item, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movies[position])


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        init {
//            itemView.setOnClickListener {
//                onClick(movies[adapterPosition])
//            }
//        }

        fun bind(movie: Movie) {
            itemView.toplist_number.text = (movies.indexOf(movie) + 1).toString()
            itemView.toplist_title.text = movie.title
            itemView.toplist_avr_rating.text = movie.voteAverage.toString()
            itemView.toplist_personal_rating.text = movie.userRating.toString()
            Glide.with(context).load(movie.getPosterImageUrl()).into(itemView.toplist_backdrop)

        }

    }


}