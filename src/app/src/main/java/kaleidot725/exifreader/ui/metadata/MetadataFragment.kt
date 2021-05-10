package kaleidot725.exifreader.ui.metadata

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
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
        binding.searchView.addTextChangedListener { editable ->
            val text = editable.toString()
            viewModel.updateSearchText(text)
            if (text.isEmpty()) viewModel.load(path)
        }
        binding.searchButton.setOnClickListener {
            viewModel.load(path)
            hideSoftKeyboard(activity)
        }
    }

    private fun setupObserve() {
        viewModel.load(path)
        viewModel.metas.observe(viewLifecycleOwner) {
            metadataAdapter.update(it)
        }
    }

    private fun hideSoftKeyboard(activity: FragmentActivity?) {
        if (activity?.currentFocus == null) {
            return
        }
        val inputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        inputMethodManager?.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0)
    }
}
