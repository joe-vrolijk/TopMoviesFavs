package nl.joevrolijk.topmoviesfavs.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import nl.joevrolijk.topmoviesfavs.R


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
                startActivityForResult(intent, ADD_MOVIE_REQUEST_CODE)
            }
            "view" -> {
                Toast.makeText(this@MainActivity, "Navigate to View List!", Toast.LENGTH_LONG)
                    .show()
            }
            "delete" -> {
                Toast.makeText(this@MainActivity, "Navigate to Delete!", Toast.LENGTH_LONG).show()
            }
            "change" -> {
                Toast.makeText(this@MainActivity, "Navigate to Change!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
