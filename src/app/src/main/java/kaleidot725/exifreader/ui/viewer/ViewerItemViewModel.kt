package kaleidot725.exifreader.ui.viewer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kaleidot725.exifreader.data.Picture
import kaleidot725.exifreader.repository.PictureRepository

class ViewerItemViewModel(private val repository: PictureRepository) : ViewModel() {
    private val _picture: MutableLiveData<Picture> = MutableLiveData()
    val picture: LiveData<Picture> = _picture

    fun updatePosition(position: Int) {
        val picture = repository.getByIndex(position) ?: return
        _picture.postValue(picture)
    }
}
