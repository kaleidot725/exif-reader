package kaleidot725.exifreader.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kaleidot725.exifreader.R
import kaleidot725.exifreader.databinding.HomeFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel by viewModel()
    private val navController: NavController get() = findNavController()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        homeViewModel.getAllPictures()
        return DataBindingUtil.inflate<HomeFragmentBinding>(inflater, R.layout.home_fragment, container, false).apply {
            vm = homeViewModel
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = this.view?.findViewById<RecyclerView>(R.id.picture_recycler_view)
        val recyclerAdapter = PictureAdapter(this)
        recyclerView?.adapter = recyclerAdapter
        recyclerView?.layoutManager = GridLayoutManager(context, 3)
        recyclerView?.setHasFixedSize(true)
        recyclerAdapter.onClick = { picture ->
            val action = HomeFragmentDirections.actionHomeFragmentToViewerFragment(picture.path)
            navController.navigate(action)
        }

        homeViewModel.pictures.observe(this, Observer {
            recyclerAdapter.update(it)
        })
    }
}