package kaleidot725.exifreader.ui.viewer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kaleidot725.exifreader.data.PictureRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ViewerItemViewModel(val repository : PictureRepository) : ViewModel() {
    private val _src : MutableLiveData<String> = MutableLiveData()
    val src : LiveData<String> = _src

    fun load(position: Int) {
        viewModelScope.launch {
            _src.postValue(repository.all()[position].path)
        }
    }
}
