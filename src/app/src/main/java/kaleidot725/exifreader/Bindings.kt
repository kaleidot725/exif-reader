package kaleidot725.exifreader

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import java.io.File

@BindingAdapter("app:imageUrl")
fun loadImage(view: ImageView, imagePath: String?) {
    if (imagePath == null) {
        return
    }

    view.load(Uri.fromFile(File(imagePath)))
}