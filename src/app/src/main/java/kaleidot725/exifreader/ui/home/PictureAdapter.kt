package kaleidot725.exifreader.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import kaleidot725.exifreader.R
import kaleidot725.exifreader.data.Picture

class PictureAdapter(private val owner: LifecycleOwner) : RecyclerView.Adapter<PictureViewHolder>() {
    var onClick: ((p: Picture) -> Unit) = {}

    private val pictures: MutableList<Picture> = mutableListOf()

    fun update(new: List<Picture>) {
        pictures.clear()
        pictures.addAll(new)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.picture_item_view, parent, false)
        return PictureViewHolder(view, owner)
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.itemView.setOnClickListener { onClick(pictures[position]) }
        holder.bind(pictures[position])
    }

    override fun getItemCount(): Int = pictures.count()
}