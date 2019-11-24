package kaleidot725.exifreader.ui.viewer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kaleidot725.exifreader.R
import kaleidot725.exifreader.databinding.ViewerItemFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class ViewerItemFragment : Fragment() {

    companion object {
        fun newInstance(position: Int) = ViewerItemFragment().also {
            val bundle = Bundle()
            bundle.putInt("position", position)
            it.arguments = bundle
        }
    }

    val viewerItemViewModel: ViewerItemViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.viewer_item_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DataBindingUtil.bind<ViewerItemFragmentBinding>(this.view as View)
        binding?.lifecycleOwner = this
        binding?.vm = viewerItemViewModel

        val position = arguments?.getInt("position") ?: 0
        viewerItemViewModel.load(position)
    }
}
