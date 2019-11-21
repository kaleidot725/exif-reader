package kaleidot725.exifreader.ui.viewer

import androidx.lifecycle.ViewModel
import kaleidot725.exifreader.data.Picture
import kaleidot725.exifreader.data.PictureRepository

class ViewerViewModel(val repository : PictureRepository) : ViewModel() {
    private var picture : Picture = repository.all()[0]
    fun getCount() : Int = repository.count()
    fun getCurrentPicture() : Picture = picture
    fun getCurrentPicturePosition() : Int = repository.all().indexOf(picture)
    fun update(position: Int) { picture = repository.all()[position] }
    fun update(path: String) { picture = repository.all().first { it.path == path }}
}
