package kaleidot725.exifreader.ui.viewer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kaleidot725.exifreader.data.Picture
import kaleidot725.exifreader.repository.PictureRepository
import kotlinx.coroutines.launch

class ViewerViewModel(private val repository: PictureRepository) : ViewModel() {
    private val _picture: MutableLiveData<Picture> = MutableLiveData()
    val picture: LiveData<Picture> = _picture

    private val _index: MutableLiveData<Int> = MutableLiveData(0)
    val index: LiveData<Int> = _index

    private val _count: MutableLiveData<Int> = MutableLiveData()
    val count: LiveData<Int> = _count

    init {
        viewModelScope.launch {
            _count.value = repository.count()
            _picture.value = repository.getAll().first()
        }
    }

    fun updateByPosition(position: Int) {
        viewModelScope.launch {
            val picture = repository.getByIndex(position)
            _picture.value = picture
            _index.value = position
        }
    }

    fun updateByPath(path: String) {
        viewModelScope.launch {
            val picture = repository.getByPath(path) ?: return@launch
            _picture.value = picture
            _index.value = repository.getIndex(picture)
        }
    }

    fun getCurrentPictureCount(): Int {
        return count.value!!
    }

    fun getCurrentPictureIndex(): Int {
        return index.value!!
    }

    fun getCurrentPicture(): Picture {
        return picture.value!!
    }
}
