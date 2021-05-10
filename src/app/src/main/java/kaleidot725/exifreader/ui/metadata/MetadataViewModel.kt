package kaleidot725.exifreader.ui.metadata

import android.util.Log
import androidx.lifecycle.*
import kaleidot725.exifreader.data.Metadata
import kaleidot725.exifreader.repository.PictureRepository
import kotlinx.coroutines.launch

class MetadataViewModel(private val repository: PictureRepository) : ViewModel() {
    private val _metas: MutableLiveData<List<Metadata>> = MutableLiveData()
    val metas: LiveData<List<Metadata>> = _metas
    val notFoundMetas: LiveData<Boolean> = metas.map { it.isEmpty() }

    private val _searchText: MutableLiveData<String> = MutableLiveData("")
    val searchText: LiveData<String> = _searchText

    fun load(path: String) {
        viewModelScope.launch {
            try {
                val picture = repository.getByPath(path) ?: return@launch
                val searchText = _searchText.value ?: ""
                val metadataList = repository.getMetadata(picture)
                val filteredMetadataList = if (searchText.isNotEmpty()) metadataList.filter { metadata ->
                    val regex = Regex(searchText)
                    regex.containsMatchIn(metadata.name)
                } else metadataList

                _metas.postValue(filteredMetadataList)
            } catch (e: Exception) {
                Log.e("MedatadataViewModel", e.toString())
            }
        }
    }

    fun updateSearchText(text: String) {
        _searchText.value = text
    }
}