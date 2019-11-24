package kaleidot725.exifreader.ui.home

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.ImageLoader
import kaleidot725.exifreader.R
import kotlinx.coroutines.launch

class PictureItemViewModel(private val imageLoader: ImageLoader) : ViewModel() {

    private var _navigate: ((Int, String) -> Unit)? = null
    private val _src: MutableLiveData<String> = MutableLiveData()
    val src: LiveData<String> = _src

    private val _loader: MutableLiveData<ImageLoader> = MutableLiveData<ImageLoader>().also {
        it.value = imageLoader
    }
    val loader: LiveData<ImageLoader> = _loader

    fun load(path: String, navigate: (Int, String) -> Unit) {
        viewModelScope.launch {
            _src.value = path
            _navigate = navigate
        }
    }

    fun preview(view: View) {
        viewModelScope.launch {
            _navigate?.invoke(R.id.action_homeFragment_to_viewerFragment, _src.value ?: "")
        }
    }
}