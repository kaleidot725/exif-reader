package kaleidot725.exifreader.ui.home

import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import kaleidot725.exifreader.R
import kaleidot725.exifreader.data.Picture
import java.io.File

class PictureViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val imageView = view.findViewById<ImageView>(R.id.image_view)

    fun bind(picture: Picture) {
        imageView.load(Uri.fromFile(File(picture.path)))
    }
}