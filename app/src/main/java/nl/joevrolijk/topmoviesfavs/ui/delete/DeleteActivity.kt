package nl.joevrolijk.topmoviesfavs.ui.delete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_delete.*
import kotlinx.android.synthetic.main.delete_edit_item.*
import nl.joevrolijk.topmoviesfavs.R
import nl.joevrolijk.topmoviesfavs.model.Movie
import nl.joevrolijk.topmoviesfavs.viewmodel.DeleteViewModel

class DeleteActivity : AppCompatActivity() {

    private val movies = arrayListOf<Movie>()
    private val deleteAdapter = DeleteAdapter(movies)
    private lateinit var viewModel: DeleteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)
        supportActionBar?.title = "Delete a movie from your list"
        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(true)

        initViews()
        initViewModel()



    }

    private fun initViews(){
        delete_rv.layoutManager = LinearLayoutManager(this@DeleteActivity, RecyclerView.VERTICAL, false)
        delete_rv.adapter = deleteAdapter
        createItemTouchHelper().attachToRecyclerView(delete_rv)

    }

    private fun initViewModel(){
        viewModel = ViewModelProviders.of(this).get(DeleteViewModel::class.java)
        viewModel.movies.observe(this, Observer { movies ->
            this@DeleteActivity.movies.clear()
            this@DeleteActivity.movies.addAll(movies.sorted())
            deleteAdapter.notifyDataSetChanged()
        })
    }


    private fun createItemTouchHelper(): ItemTouchHelper {
        val callback = object: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT){

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val movieToDelete = movies[position]
                viewModel.deleteMovie(movieToDelete)
            }
        }
        return ItemTouchHelper(callback)
    }
}
