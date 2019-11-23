package kaleidot725.exifreader.ui.viewer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kaleidot725.exifreader.data.PictureRepository

class ViewerItemViewModel(val repository : PictureRepository) : ViewModel() {
    private val _src : MutableLiveData<String> = MutableLiveData()
    val src : LiveData<String> = _src

    fun load(position: Int) {
        _src.postValue(repository.all()[position].path)
    }
}
