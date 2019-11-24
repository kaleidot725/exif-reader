package kaleidot725.exifreader.ui.metadata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kaleidot725.exifreader.data.PictureRepository
import kotlinx.coroutines.launch

class MetadataViewModel(private val repository : PictureRepository) : ViewModel() {
    private val _vms : MutableLiveData<List<MetadataItemViewModel>> = MutableLiveData()
    val vms : LiveData<List<MetadataItemViewModel>> = _vms

    fun load(path: String) {
        viewModelScope.launch {
            val picture = repository.get(path) ?: return@launch
            val metadatas = picture.getMetadata()
            val newVms = metadatas.map { m -> MetadataItemViewModel().also { vm -> vm.load(m) } }
            _vms.postValue(newVms)
        }
    }
}