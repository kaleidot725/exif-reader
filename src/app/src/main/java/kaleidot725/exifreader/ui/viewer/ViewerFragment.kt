package kaleidot725.exifreader.ui.viewer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.findNavController
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kaleidot725.exifreader.R
import kaleidot725.exifreader.databinding.ViewerFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class ViewerFragment : Fragment() {
    val viewerViewModel : ViewerViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.viewer_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = DataBindingUtil.bind<ViewerFragmentBinding>(this.view as View)
        binding?.lifecycleOwner = this
        binding?.vm = viewerViewModel

        val path = ViewerFragmentArgs.fromBundle(arguments as Bundle).path
        viewerViewModel.update(path)

        val viewPager = view.findViewById<ViewPager>(R.id.viewpager)
        viewPager.adapter = object : FragmentPagerAdapter(activity!!.supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            override fun getCount(): Int {
                return viewerViewModel.getCount()
            }

            override fun getItem(position: Int): Fragment {
                return ViewerItemFragment.newInstance(position)
            }
        }
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageSelected(position: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                viewerViewModel.update(position)
            }
        })
        viewPager.currentItem = viewerViewModel.getCurrentPicturePosition()

        val floatingButton = view.findViewById<FloatingActionButton>(R.id.floating_button)
        floatingButton.setOnClickListener {
            val picture = viewerViewModel.getCurrentPicture()
            val action = ViewerFragmentDirections.actionViewerFragmentToMetadataFragment(picture.path)
            view.findNavController().navigate(action)
        }
    }
}
