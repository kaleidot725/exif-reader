package kaleidot725.exifreader.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import coil.Coil
import coil.ImageLoader
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.LibsBuilder
import kaleidot725.exifreader.R
import kaleidot725.exifreader.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private var menuItem: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host_fragment)
        navController.addOnDestinationChangedListener(destinationChangedListener)
        setupActionBarWithNavController(this, navController)

        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(appModule)
            Coil.setDefaultImageLoader(ImageLoader(applicationContext) {
                availableMemoryPercentage(0.25)
                crossfade(10)
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (navController.currentDestination?.id == R.id.homeFragment) {
            menuInflater.inflate(R.menu.toolbar_menu, menu)
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.privacy_policy -> {
                navController.navigate(R.id.action_homeFragment_to_privacyPolicyFragment)
            }
            R.id.license -> {
                LibsBuilder()
                    .withActivityTitle("License")
                    .withShowLoadingProgress(false)
                    .withActivityStyle(Libs.ActivityStyle.LIGHT_DARK_TOOLBAR).start(this)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private val destinationChangedListener = object : NavController.OnDestinationChangedListener {
        override fun onDestinationChanged(controller: NavController, destination: NavDestination, arguments: Bundle?) {
            invalidateOptionsMenu()
        }
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.nav_host_fragment).navigateUp()
}
