package kaleidot725.exifreader.ui.home

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kaleidot725.exifreader.R

class PictureCardViewModel(
    private val srcPath: String,
    private val navigate: (Int, String) -> Unit) : ViewModel() {

    private val _src : MutableLiveData<String> = MutableLiveData()
    val src : LiveData<String> = _src

    init {
        _src.value = srcPath
    }

    fun preview(view : View) {
        navigate(R.id.action_homeFragment_to_viewerFragment,srcPath)
    }
}