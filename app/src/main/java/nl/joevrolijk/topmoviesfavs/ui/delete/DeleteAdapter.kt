package nl.joevrolijk.topmoviesfavs.ui.delete

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.delete_item.view.*
import kotlinx.android.synthetic.main.toplist_item.view.*
import nl.joevrolijk.topmoviesfavs.R
import nl.joevrolijk.topmoviesfavs.model.Movie

class DeleteAdapter(private val movies: List<Movie>): RecyclerView.Adapter<DeleteAdapter.ViewHolder>() {
    lateinit var  context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeleteAdapter.ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.delete_item, parent, false))
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: DeleteAdapter.ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(movie: Movie){
            itemView.delete_title.text = movie.title + " (" + movie.releaseDate + ")"
            Glide.with(context).load(movie.getPosterImageUrl()).into(itemView.delete_poster)
        }
    }
}
