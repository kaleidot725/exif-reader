package kaleidot725.exifreader.ui.viewer

import androidx.lifecycle.ViewModel
import kaleidot725.exifreader.data.Picture
import kaleidot725.exifreader.repository.PictureRepository

class ViewerViewModel(private val repository: PictureRepository) : ViewModel() {
    private var picture: Picture = repository.all()[0]
    fun getCount(): Int = repository.count()
    fun getCurrentPicture(): Picture = picture
    fun getCurrentPicturePosition(): Int = repository.all().indexOf(picture)

    fun updateByPosition(position: Int) {
        picture = repository.all()[position]
    }

    fun updateByPath(path: String) {
        picture = repository.all().first { it.path == path }
    }
}
