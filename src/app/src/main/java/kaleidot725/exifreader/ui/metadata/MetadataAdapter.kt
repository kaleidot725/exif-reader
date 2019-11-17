package kaleidot725.exifreader.ui.metadata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import kaleidot725.exifreader.R
import kaleidot725.exifreader.databinding.MetadateItemViewBinding
import kaleidot725.exifreader.databinding.PictureItemViewBinding
import kaleidot725.exifreader.ui.home.PictureItemViewModel
import kaleidot725.exifreader.ui.home.PictureViewHolder

class MetadataAdapter(private val owner: LifecycleOwner) : RecyclerView.Adapter<MetadataItemHolder>() {
    private val vms : MutableList<MetadataItemViewModel> = mutableListOf()

    fun update(new: List<MetadataItemViewModel>) {
        vms.clear()
        vms.addAll(new)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MetadataItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<MetadateItemViewBinding>(inflater, R.layout.metadate_item_view, parent, false)
        return MetadataItemHolder(owner, binding.root, binding)
    }

    override fun onBindViewHolder(holder: MetadataItemHolder, position: Int) {
        holder.bind(vms[position])
    }

    override fun getItemCount(): Int = vms.count()
}
