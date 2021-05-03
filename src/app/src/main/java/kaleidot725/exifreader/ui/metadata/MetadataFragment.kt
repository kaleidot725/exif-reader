package kaleidot725.exifreader.ui.metadata

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kaleidot725.exifreader.R
import kaleidot725.exifreader.databinding.MetadataFragmentBinding
import kaleidot725.exifreader.extention.dataBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MetadataFragment : Fragment(R.layout.metadata_fragment) {
    private val viewModel: MetadataViewModel by viewModel()
    private val _binding: MetadataFragmentBinding? by dataBinding()
    private val binding: MetadataFragmentBinding get() = _binding!!

    private lateinit var path: String
    private lateinit var metadataAdapter: MetadataAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVariable()
        setupView()
        setupObserve()
    }

    private fun setupVariable() {
        path = MetadataFragmentArgs.fromBundle(arguments as Bundle).path
        metadataAdapter = MetadataAdapter(this)
    }

    private fun setupView() {
        binding.vm = viewModel
        binding.metadataRecyclerView.apply {
            this.adapter = metadataAdapter
            this.layoutManager = LinearLayoutManager(context)
            this.setHasFixedSize(true)
        }
    }

    private fun setupObserve() {
        viewModel.load(path)
        viewModel.metas.observe(viewLifecycleOwner) {
            metadataAdapter.update(it)
        }
    }
}
