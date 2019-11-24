package kaleidot725.exifreader.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import kaleidot725.exifreader.R
import kaleidot725.exifreader.databinding.PictureItemViewBinding

class PictureAdapter(private val owner: LifecycleOwner) :
    RecyclerView.Adapter<PictureViewHolder>() {
    private val vms: MutableList<PictureItemViewModel> = mutableListOf()

    fun update(new: List<PictureItemViewModel>) {
        vms.clear()
        vms.addAll(new)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<PictureItemViewBinding>(
                inflater,
                R.layout.picture_item_view,
                parent,
                false
            )
        return PictureViewHolder(owner, binding.root, binding)
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.bind(vms[position])
    }

    override fun getItemCount(): Int = vms.count()
}