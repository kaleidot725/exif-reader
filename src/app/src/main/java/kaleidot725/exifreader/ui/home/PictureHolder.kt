package kaleidot725.exifreader.ui.home

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import kaleidot725.exifreader.databinding.PictureCardBinding

class PictureViewHolder(
    private val owner: LifecycleOwner,
    private val itemView: View,
    private val binding: PictureCardBinding
) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(vm: PictureCardViewModel?) {
        binding.vm = vm
        binding.executePendingBindings()
        binding.lifecycleOwner = owner
    }
}