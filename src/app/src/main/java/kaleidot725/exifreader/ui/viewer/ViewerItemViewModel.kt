package kaleidot725.exifreader.ui.viewer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kaleidot725.exifreader.repository.PictureRepository

class ViewerItemViewModel(private val repository: PictureRepository) : ViewModel() {
    private val _path: MutableLiveData<String> = MutableLiveData()
    val path: LiveData<String> = _path

    fun updatePosition(position: Int) {
        _path.postValue(repository.all()[position].path)
    }
}
