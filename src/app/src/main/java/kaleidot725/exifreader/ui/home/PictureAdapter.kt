package kaleidot725.exifreader.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import kaleidot725.exifreader.R
import kaleidot725.exifreader.databinding.PictureCardBinding

class PictureAdapter(private val owner: LifecycleOwner) : RecyclerView.Adapter<PictureViewHolder>() {
    private val vms : MutableList<PictureCardViewModel> = mutableListOf()

    fun update(new: List<PictureCardViewModel>) {
        vms.clear()
        vms.addAll(new)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<PictureCardBinding>(inflater, R.layout.picture_card, parent, false)
        return PictureViewHolder(owner, binding.root, binding)
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.bind(vms[position])
    }

    override fun getItemCount(): Int = vms.count()
}