package kaleidot725.exifreader.ui.home

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import kaleidot725.exifreader.R
import kaleidot725.exifreader.data.Picture

class PictureViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val imageView = view.findViewById<ImageView>(R.id.image_view)

    fun bind(picture: Picture) {
        imageView.load(picture.uri)
    }
}