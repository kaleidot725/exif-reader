package kaleidot725.exifreader.ui.metadata

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kaleidot725.exifreader.data.Metadata
import kaleidot725.exifreader.repository.PictureRepository
import kotlinx.coroutines.launch

class MetadataViewModel(private val repository: PictureRepository) : ViewModel() {
    private val _metas: MutableLiveData<List<Metadata>> = MutableLiveData()
    val metas: LiveData<List<Metadata>> = _metas

    fun load(path: String) {
        viewModelScope.launch {
            try {
                val picture = repository.getByPath(path) ?: return@launch
                val metadataList = repository.getMetadata(picture) ?: return@launch
                _metas.postValue(metadataList)
            } catch (e: Exception) {
                // FIXME
                Log.e("MedatadataViewModel", e.toString())
            }
        }
    }
}