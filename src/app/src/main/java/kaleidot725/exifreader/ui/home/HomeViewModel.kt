package kaleidot725.exifreader.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.ImageLoader
import kaleidot725.exifreader.data.Picture
import kaleidot725.exifreader.repository.PictureRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: PictureRepository,
    private val imageLoader: ImageLoader
) : ViewModel() {

    private val _pictures: MutableLiveData<List<Picture>> = MutableLiveData()
    val pictures: LiveData<List<Picture>> = _pictures

    fun getAllPictures() {
        viewModelScope.launch {
            _pictures.postValue(repository.all())
        }
    }
}
