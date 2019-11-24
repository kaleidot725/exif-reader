package kaleidot725.exifreader.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kaleidot725.exifreader.R
import kaleidot725.exifreader.databinding.HomeFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.load { id, src ->
            when (id) {
                R.id.action_homeFragment_to_viewerFragment -> {
                    val action = HomeFragmentDirections.actionHomeFragmentToViewerFragment(src)
                    view.findNavController().navigate(action)
                }
            }
        }

        val binding = DataBindingUtil.bind<HomeFragmentBinding>(this.view as View)
        binding?.lifecycleOwner = this
        binding?.vm = homeViewModel

        val recyclerView = this.view?.findViewById<RecyclerView>(R.id.picture_recycler_view)
        val recyclerAdapter = PictureAdapter(this)
        recyclerView?.adapter = recyclerAdapter
        recyclerView?.layoutManager = GridLayoutManager(context, 3)
        recyclerView?.setHasFixedSize(true)
        homeViewModel.vms.observe(this, Observer { recyclerAdapter.update(it) })
    }
}
