package nl.joevrolijk.topmoviesfavs.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import nl.joevrolijk.topmoviesfavs.R
import nl.joevrolijk.topmoviesfavs.ui.delete.DeleteActivity
import nl.joevrolijk.topmoviesfavs.ui.edit.EditActivity
import nl.joevrolijk.topmoviesfavs.ui.search.SearchMovie
import nl.joevrolijk.topmoviesfavs.ui.toplist.TopListActivity


const val ADD_MOVIE_REQUEST_CODE = 100

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        btn_view.setOnClickListener {
            startNavigation("view")
        }

        btn_add.setOnClickListener {
            startNavigation("search")
        }

        btn_delete.setOnClickListener {
            startNavigation("delete")
        }

        btn_change.setOnClickListener {
            startNavigation("change")
        }

    }


    private fun startNavigation(view: String) {
        when (view) {
            "search" -> {
                val intent = Intent(this, SearchMovie::class.java)
                startActivityForResult(
                    intent,
                    ADD_MOVIE_REQUEST_CODE
                )
            }
            "view" -> {
                val intent = Intent(this, TopListActivity::class.java )
                startActivityForResult(
                    intent,
                    ADD_MOVIE_REQUEST_CODE
                )
            }
            "delete" -> {
                val intent = Intent(this, DeleteActivity::class.java)
                startActivityForResult(
                    intent,
                    ADD_MOVIE_REQUEST_CODE
                )
            }
            "change" -> {
                val intent = Intent(this, EditActivity::class.java)
                startActivityForResult(
                    intent,
                    ADD_MOVIE_REQUEST_CODE
                )
            }
        }
    }
}
