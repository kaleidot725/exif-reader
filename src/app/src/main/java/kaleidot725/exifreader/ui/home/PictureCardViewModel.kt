package kaleidot725.exifreader.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PictureCardViewModel(srcPath: String) : ViewModel() {
    private val _src : MutableLiveData<String> = MutableLiveData()
    val src : LiveData<String> = _src

    init {
        _src.value = srcPath
    }

}