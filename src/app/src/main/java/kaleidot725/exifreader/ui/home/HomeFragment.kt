package kaleidot725.exifreader.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kaleidot725.exifreader.R
import kaleidot725.exifreader.databinding.HomeFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    val homeViewModel : HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = DataBindingUtil.bind<HomeFragmentBinding>(this.view as View)
        binding?.lifecycleOwner = this
        binding?.vm = homeViewModel

        val recyclerView = this.view?.findViewById<RecyclerView>(R.id.picture_recycler_view)
        recyclerView?.adapter = PictureAdapter(this, homeViewModel.vms.value?.toMutableList() ?: mutableListOf())
        recyclerView?.layoutManager = GridLayoutManager(context, 3)
        recyclerView?.setHasFixedSize(true)
    }
}
