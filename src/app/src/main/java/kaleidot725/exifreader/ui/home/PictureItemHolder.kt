package kaleidot725.exifreader.ui.home

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import kaleidot725.exifreader.databinding.PictureItemViewBinding

class PictureViewHolder(
    private val owner: LifecycleOwner,
    private val itemView: View,
    private val binding: PictureItemViewBinding
) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(vm: PictureItemViewModel?) {
        binding.vm = vm
        binding.executePendingBindings()
        binding.lifecycleOwner = owner
    }
}