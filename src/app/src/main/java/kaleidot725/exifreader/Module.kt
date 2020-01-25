package kaleidot725.exifreader

import coil.ImageLoader
import kaleidot725.exifreader.repository.PictureRepository
import kaleidot725.exifreader.repository.PictureRepositoryImpl
import kaleidot725.exifreader.ui.home.HomeViewModel
import kaleidot725.exifreader.ui.metadata.MetadataViewModel
import kaleidot725.exifreader.ui.viewer.ViewerItemViewModel
import kaleidot725.exifreader.ui.viewer.ViewerViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        (PictureRepositoryImpl(androidContext()) as PictureRepository).apply { load() }
    }

    single {
        ImageLoader(androidContext()) {
            crossfade(10)
        }
    }

    viewModel {
        HomeViewModel(get(), get())
    }
    viewModel {
        ViewerItemViewModel(get(), get())
    }
    viewModel {
        ViewerViewModel(get())
    }
    viewModel {
        MetadataViewModel(get())
    }
}
