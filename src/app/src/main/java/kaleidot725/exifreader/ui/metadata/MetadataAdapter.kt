package kaleidot725.exifreader.ui.metadata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import kaleidot725.exifreader.R
import kaleidot725.exifreader.data.Metadata
import kaleidot725.exifreader.databinding.MetadateItemViewBinding

class MetadataAdapter(private val owner: LifecycleOwner) :
    RecyclerView.Adapter<MetadataItemHolder>() {
    private val metas: MutableList<Metadata> = mutableListOf()

    fun update(new: List<Metadata>) {
        metas.clear()
        metas.addAll(new)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MetadataItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<MetadateItemViewBinding>(
            inflater,
            R.layout.metadate_item_view,
            parent,
            false
        )
        return MetadataItemHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MetadataItemHolder, position: Int) {
        holder.bind(metas[position])
    }

    override fun getItemCount(): Int = metas.count()
}
