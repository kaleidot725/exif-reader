package kaleidot725.exifreader.ui.home

import androidx.lifecycle.*
import kaleidot725.exifreader.data.Picture
import kaleidot725.exifreader.repository.PictureRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: PictureRepository) : ViewModel() {
    private val _pictures: MutableLiveData<List<Picture>> = MutableLiveData()
    val pictures: LiveData<List<Picture>> = _pictures
    val notFoundPicture: LiveData<Boolean> = pictures.map { it.isEmpty() }

    fun refresh() {
        viewModelScope.launch {
            _pictures.postValue(repository.getAll())
        }
    }
}
