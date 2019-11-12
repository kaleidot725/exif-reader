package kaleidot725.exifreader.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kaleidot725.exifreader.data.PictureRepository

class HomeViewModel(val repo : PictureRepository) : ViewModel() {
    private val _vms : MutableLiveData<List<PictureCardViewModel>> = MutableLiveData()
    val vms : LiveData<List<PictureCardViewModel>> = _vms

    init {
        val list = mutableListOf<PictureCardViewModel>()
        val all = repo.all()

        all.forEach { list.add(PictureCardViewModel(it.path)) }
        _vms.value = list
    }
}
