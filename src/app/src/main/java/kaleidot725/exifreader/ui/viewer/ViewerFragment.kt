package kaleidot725.exifreader.ui.viewer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kaleidot725.exifreader.R
import kaleidot725.exifreader.databinding.ViewerFragmentBinding
import kaleidot725.exifreader.extention.dataBinding
import org.koin.android.viewmodel.ext.android.viewModel

class ViewerFragment : Fragment(R.layout.viewer_fragment) {
    private val navController: NavController get() = findNavController()
    private val viewerViewModel: ViewerViewModel by viewModel()
    private val _binding: ViewerFragmentBinding? by dataBinding()
    private val binding: ViewerFragmentBinding get() = _binding!!

    private lateinit var path: String
    private lateinit var viewPagerAdapter: FragmentStateAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVariable()
        setupView()
        setupObserver()
    }

    private fun setupVariable() {
        path = ViewerFragmentArgs.fromBundle(arguments as Bundle).path
        viewPagerAdapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return viewerViewModel.getCount()
            }

            override fun createFragment(position: Int): Fragment {
                return ViewerItemFragment.newInstance(position)
            }
        }
    }

    private fun setupView() {
        binding.vm = viewerViewModel
        binding.viewpager.apply {
            adapter = viewPagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    viewerViewModel.updateByPosition(position)
                }
            })
            setCurrentItem(viewerViewModel.getCurrentPicturePosition(), false)
        }
        binding.floatingButton.setOnClickListener {
            val picture = viewerViewModel.getCurrentPicture()
            val action = ViewerFragmentDirections.actionViewerFragmentToMetadataFragment(picture.path)
            navController.navigate(action)
        }
    }

    private fun setupObserver() {
        viewerViewModel.updateByPath(path)
    }
}
