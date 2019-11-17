package kaleidot725.exifreader.ui.metadata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kaleidot725.exifreader.data.Metadata

class MetadataItemViewModel : ViewModel() {
    private val _name : MutableLiveData<String> = MutableLiveData()
    val name : LiveData<String> = _name

    private val _value : MutableLiveData<String> = MutableLiveData()
    val value : LiveData<String> = _value

    fun load(metadata: Metadata) {
        _name.value = metadata.name
        _value.value = metadata.value
    }
}