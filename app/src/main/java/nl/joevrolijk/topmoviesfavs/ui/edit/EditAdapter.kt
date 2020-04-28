package nl.joevrolijk.topmoviesfavs.ui.edit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.delete_edit_item.view.*
import nl.joevrolijk.topmoviesfavs.R
import nl.joevrolijk.topmoviesfavs.model.Movie
import nl.joevrolijk.topmoviesfavs.ui.delete.DeleteAdapter

class EditAdapter(private val movies: List<Movie>, private val  onClick: (Movie) -> Unit) : RecyclerView.Adapter<EditAdapter.ViewHolder>()  {
    lateinit var  context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditAdapter.ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.delete_edit_item, parent, false))
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: EditAdapter.ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        init {
            itemView.setOnClickListener {
                onClick(movies[adapterPosition])
            }
        }

        fun bind(movie: Movie){
            itemView.delete_title.text = movie.title + " (" + movie.releaseDate + ")"
            Glide.with(context).load(movie.getPosterImageUrl()).into(itemView.delete_poster)
        }
    }

}
