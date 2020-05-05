package nl.joevrolijk.topmoviesfavs.ui.rating

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_rating.*
import nl.joevrolijk.topmoviesfavs.R

class RatingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)

        initNavigation()
    }

    private fun initNavigation() {
        // The NavController
        val navController = findNavController(R.id.navHostFragment)

        // Connect the navHostFragment with the BottomNavigationView.
        NavigationUI.setupWithNavController(navView, navController)

        // Connect the navHostFragment with the Toolbar.
//        val appBarConfiguration = AppBarConfiguration(navController.graph)
//        toolbar.setupWithNavController(navController, appBarConfiguration)

        // Add a Destination Changed Listener. This gets called whenever the navigation controller is navigating to another fragment.
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.aboutUsFragment -> showBottomNavigationBar(true)
                R.id.rateFragment -> showBottomNavigationBar(true)
                R.id.ratedFragment -> showBottomNavigationBar(false)
            }
        }
    }

    private fun showBottomNavigationBar(visible: Boolean) {
        when (visible) {
            true -> navView.visibility = View.VISIBLE
            false -> navView.visibility = View.GONE
        }
    }
}


