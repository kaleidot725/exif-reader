package kaleidot725.exifreader

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.ImageLoader
import coil.api.load
import java.io.File

@BindingAdapter("app:imageUrl", "app:imageLoader")
fun loadImage(view: ImageView, imagePath: String?, imageLoader: ImageLoader) {
    if (imagePath == null) {
        return
    }

    view.load(Uri.fromFile(File(imagePath)), imageLoader)
}