package kaleidot725.exifreader.ui.viewer

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kaleidot725.exifreader.R
import kaleidot725.exifreader.data.PictureRepository
import kaleidot725.exifreader.databinding.ViewerFragmentBinding
import kaleidot725.exifreader.loadImage
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import java.io.File

class ViewerItemFragment : Fragment() {

    companion object {
        fun newInstance(position: Int) = ViewerItemFragment().also {
            val bundle = Bundle()
            bundle.putInt("position", position)
            it.arguments = bundle
        }
    }

    val pictureRepository : PictureRepository by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.viewer_item_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val position = arguments?.getInt("position") ?: 0
        val picture = pictureRepository.all()[position]
        val imageView = view.findViewById<ImageView>(R.id.image_view)
        loadImage(imageView, picture.path)
    }
}
