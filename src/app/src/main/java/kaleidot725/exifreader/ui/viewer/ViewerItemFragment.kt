package kaleidot725.exifreader.ui.viewer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kaleidot725.exifreader.R
import kaleidot725.exifreader.databinding.ViewerItemFragmentBinding
import kaleidot725.exifreader.extention.dataBinding
import org.koin.android.viewmodel.ext.android.viewModel

class ViewerItemFragment : Fragment(R.layout.viewer_item_fragment) {
    private val viewerItemViewModel: ViewerItemViewModel by viewModel()
    private val _binding: ViewerItemFragmentBinding? by dataBinding()
    private val binding: ViewerItemFragmentBinding get() = _binding!!

    private var position: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVariable()
        setupView()
        setupObserver()
    }

    private fun setupVariable() {
        position = arguments?.getInt("position") ?: 0
    }

    private fun setupView() {
        binding.vm = viewerItemViewModel
    }

    private fun setupObserver() {
        viewerItemViewModel.updatePosition(position)
    }

    companion object {
        fun newInstance(position: Int) = ViewerItemFragment().also {
            val bundle = Bundle()
            bundle.putInt("position", position)
            it.arguments = bundle
        }
    }
}
