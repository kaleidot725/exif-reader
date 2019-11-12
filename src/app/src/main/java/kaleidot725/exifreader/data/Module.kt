package kaleidot725.exifreader.data

import android.os.Environment
import kaleidot725.exifreader.ui.home.HomeViewModel
import kaleidot725.exifreader.ui.viewer.ViewerViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pub.devrel.easypermissions.EasyPermissions

val appModule = module {

    single {
        PictureRepositoryImpl(androidContext()) as PictureRepository
    }

    viewModel {
        HomeViewModel(get())
    }

    viewModel {
        ViewerViewModel(get())
    }
}