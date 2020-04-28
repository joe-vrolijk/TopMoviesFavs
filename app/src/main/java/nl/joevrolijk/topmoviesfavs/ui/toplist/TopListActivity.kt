package nl.joevrolijk.topmoviesfavs.ui.toplist

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_top_list.*
import nl.joevrolijk.topmoviesfavs.R
import nl.joevrolijk.topmoviesfavs.model.Movie
import nl.joevrolijk.topmoviesfavs.viewmodel.TopListViewModel

class TopListActivity : AppCompatActivity() {

    private val movies = arrayListOf<Movie>()
    private val topListAdapter = TopListAdapter(movies)
    private lateinit var viewModel: TopListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_list)
        supportActionBar?.title = "Top Movies List"
        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(true)

        initView()
        initViewModel()
    }

    private fun initView() {
        toplist_rv.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)
        toplist_rv.adapter = topListAdapter

    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(TopListViewModel::class.java)

        viewModel.movies.observe(this, Observer { movies ->
            this@TopListActivity.movies.clear()
            this@TopListActivity.movies.addAll(movies.sorted())
            topListAdapter.notifyDataSetChanged()
        })
    }

    companion object {
        const val ADD_MOVIE_REQUEST_CODE = 100
    }

    private fun startAddActivity() {
//        val intent = Intent(this, AddActivity::class.java)
//        startActivityForResult(
//            intent,
//            ADD_GAME_REQUEST_CODE
//        )
    }





}

