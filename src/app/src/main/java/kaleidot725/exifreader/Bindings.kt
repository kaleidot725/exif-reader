package kaleidot725.exifreader

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load

@BindingAdapter("app:imageUri")
fun loadImage(view: ImageView, uri: Uri?) {
    if (uri == null) {
        return
    }

    view.load(uri)
}