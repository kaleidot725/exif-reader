package kaleidot725.exifreader.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.ImageLoader
import kaleidot725.exifreader.repository.PictureRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: PictureRepository,
    private val imageLoader: ImageLoader
) : ViewModel() {

    private val _vms: MutableLiveData<List<PictureItemViewModel>> = MutableLiveData()
    val vms: LiveData<List<PictureItemViewModel>> = _vms

    fun load(navigate: (Int, String) -> Unit) {
        viewModelScope.launch {
            val newVms = repository.all()
                .map { p -> PictureItemViewModel(imageLoader).apply { load(p.path, navigate) } }
            _vms.postValue(newVms)
        }
    }
}
