package kaleidot725.exifreader.ui.viewer

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kaleidot725.exifreader.R
import kaleidot725.exifreader.data.PictureRepository

class ViewerViewModel(val repo : PictureRepository) : ViewModel() {
    private val _src : MutableLiveData<String> = MutableLiveData()
    val src : LiveData<String> = _src

    fun load(path: String) {
        _src.value = path
    }
}
