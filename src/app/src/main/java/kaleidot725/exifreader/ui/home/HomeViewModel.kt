package kaleidot725.exifreader.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kaleidot725.exifreader.data.Picture
import kaleidot725.exifreader.data.PictureRepository
import kotlinx.coroutines.launch

class HomeViewModel(val repo : PictureRepository) : ViewModel() {
    private val _vms : MutableLiveData<List<PictureCardViewModel>> = MutableLiveData()
    val vms : LiveData<List<PictureCardViewModel>> = _vms

    fun load(navigate: (Int, String) -> Unit) {
        viewModelScope.launch {
            val list = mutableListOf<PictureCardViewModel>()
            repo.all().forEach { list.add(PictureCardViewModel().apply { load(it.path, navigate) }) }
            _vms.postValue(list)
        }
    }
}
