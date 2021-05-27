package kaleidot725.exifreader.ui.home

import androidx.lifecycle.*
import kaleidot725.exifreader.data.Picture
import kaleidot725.exifreader.repository.PictureRepository

class HomeViewModel(private val repository: PictureRepository) : ViewModel() {
    private val accessible: MutableLiveData<Boolean> = MutableLiveData(false)
    val pictures: LiveData<List<Picture>> = accessible.switchMap {
        liveData {
            repository.load()
            emit(repository.getAll())
        }
    }
    val notFoundPicture: LiveData<Boolean> = pictures.map { it.isEmpty() }

    fun updateAccessible(accessible: Boolean) {
        this.accessible.value = accessible
    }
}
