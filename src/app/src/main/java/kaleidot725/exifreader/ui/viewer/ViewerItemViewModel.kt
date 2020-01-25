package kaleidot725.exifreader.ui.viewer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.ImageLoader
import kaleidot725.exifreader.repository.PictureRepository
import kotlinx.coroutines.launch

class ViewerItemViewModel(
    private val repository: PictureRepository,
    private val imageLoader: ImageLoader
) : ViewModel() {
    private val _src: MutableLiveData<String> = MutableLiveData()
    val src: LiveData<String> = _src

    private val _loader: MutableLiveData<ImageLoader> = MutableLiveData<ImageLoader>().also {
        it.value = imageLoader
    }
    val loader: LiveData<ImageLoader> = _loader

    fun load(position: Int) {
        viewModelScope.launch {
            _src.postValue(repository.all()[position].path)
        }
    }
}
