package kaleidot725.exifreader.ui.metadata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kaleidot725.exifreader.R
import kaleidot725.exifreader.databinding.MetadataFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MetadataFragment : Fragment() {

    companion object {
        fun newInstance() = MetadataFragment()
    }

    val metadataViewModel : MetadataViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.metadata_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val path = MetadataFragmentArgs.fromBundle(arguments as Bundle).path
        metadataViewModel.load(path)

        val binding = DataBindingUtil.bind<MetadataFragmentBinding>(this.view as View)
        binding?.lifecycleOwner = this
        binding?.vm = metadataViewModel

        val recyclerView = this.view?.findViewById<RecyclerView>(R.id.metadata_recycler_view)
        val recyclerAdapter = MetadataAdapter(this)
        recyclerView?.adapter = recyclerAdapter
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.setHasFixedSize(true)
        metadataViewModel.vms.observe(this , Observer { recyclerAdapter.update(it) })
    }
}
