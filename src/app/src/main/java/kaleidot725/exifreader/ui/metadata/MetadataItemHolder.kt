package kaleidot725.exifreader.ui.metadata

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import kaleidot725.exifreader.databinding.MetadateItemViewBinding

class MetadataItemHolder(
    private val owner: LifecycleOwner,
    private val itemView: View,
    private val binding: MetadateItemViewBinding
) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(vm: MetadataItemViewModel?) {
        binding.vm = vm
        binding.executePendingBindings()
        binding.lifecycleOwner = owner
    }
}