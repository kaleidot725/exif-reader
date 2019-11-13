package kaleidot725.exifreader.ui

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import kaleidot725.exifreader.R
import kaleidot725.exifreader.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import pub.devrel.easypermissions.EasyPermissions

class MainActivity : AppCompatActivity() , EasyPermissions.PermissionCallbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val permission = Manifest.permission.READ_EXTERNAL_STORAGE
        if (!EasyPermissions.hasPermissions(this, permission)) {
            EasyPermissions.requestPermissions(this, "このアプリケーションは外部ストレージにアクセスします。よろしいですか？", 0, permission)
            return
        }

        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(this, navController)

        startKoin{
            androidLogger()
            androidContext(applicationContext)
            modules(appModule)
            findNavController(R.id.nav_host_fragment).navigateUp()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, list: List<String>) {
        recreate()
    }

    override fun onPermissionsDenied(requestCode: Int, list: List<String>) {
        finish()
    }
}
