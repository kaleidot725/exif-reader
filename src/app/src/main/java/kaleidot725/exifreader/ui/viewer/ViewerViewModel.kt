package kaleidot725.exifreader.ui.viewer

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kaleidot725.exifreader.R
import kaleidot725.exifreader.data.PictureRepository

class ViewerViewModel(val repo : PictureRepository) : ViewModel() {
    private var _navigate: ((Int, String) -> Unit)? = null
    private val _src : MutableLiveData<String> = MutableLiveData()
    val src : LiveData<String> = _src

    fun load(path: String, navigate: (Int, String) -> Unit) {
        _src.value = path
        _navigate = navigate
    }

    fun displayMetadata(view: View) {
        _navigate?.invoke(R.id.action_viewerFragment_to_metadataFragment, _src.value ?: "")
    }
}
