package kaleidot725.exifreader.ui.viewer

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kaleidot725.exifreader.R
import kaleidot725.exifreader.databinding.HomeFragmentBinding
import kaleidot725.exifreader.databinding.ViewerFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class ViewerFragment : Fragment() {

    companion object {
        fun newInstance() = ViewerFragment()
    }

    val viewerViewModel : ViewerViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.viewer_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val path = ViewerFragmentArgs.fromBundle(arguments as Bundle).path
        viewerViewModel.load(path)

        val binding = DataBindingUtil.bind<ViewerFragmentBinding>(this.view as View)
        binding?.lifecycleOwner = this
        binding?.vm = viewerViewModel
    }
}
