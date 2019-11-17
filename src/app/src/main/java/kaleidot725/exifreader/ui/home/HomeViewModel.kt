package kaleidot725.exifreader.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kaleidot725.exifreader.data.PictureRepository
import kotlinx.coroutines.launch

class HomeViewModel(val repo : PictureRepository) : ViewModel() {
    private val _vms : MutableLiveData<List<PictureItemViewModel>> = MutableLiveData()
    val vms : LiveData<List<PictureItemViewModel>> = _vms

    fun load(navigate: (Int, String) -> Unit) {
        viewModelScope.launch {
            val newVms = repo.all().map { p -> PictureItemViewModel().apply { load(p.path, navigate) } }
            _vms.postValue(newVms)
        }
    }
}
