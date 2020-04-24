package nl.joevrolijk.topmoviesfavs.ui.toplist

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        initView()
        initViewModel()
    }

    private fun initView() {
        toplist_rv.layoutManager = LinearLayoutManager(this@TopListActivity, RecyclerView.VERTICAL, false)
        toplist_rv.adapter = topListAdapter

    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(TopListViewModel::class.java)

        viewModel.movies.observe(this, Observer { movies ->
            this@TopListActivity.movies.clear()
            this@TopListActivity.movies.addAll(movies)
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

