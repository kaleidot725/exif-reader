package kaleidot725.exifreader

import kaleidot725.exifreader.data.PictureRepository
import kaleidot725.exifreader.data.PictureRepositoryImpl
import kaleidot725.exifreader.ui.home.HomeViewModel
import kaleidot725.exifreader.ui.metadata.MetadataViewModel
import kaleidot725.exifreader.ui.viewer.ViewerViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        (PictureRepositoryImpl(androidContext()) as PictureRepository).apply { load() }
    }

    viewModel {
        HomeViewModel(get())
    }

    viewModel {
        ViewerViewModel(get())
    }

    viewModel {
        MetadataViewModel(get())
    }
}