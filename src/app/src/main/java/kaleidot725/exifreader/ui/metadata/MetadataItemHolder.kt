package kaleidot725.exifreader.ui.metadata

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kaleidot725.exifreader.R
import kaleidot725.exifreader.data.Metadata

class MetadataItemHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val nameTextView: TextView = view.findViewById(R.id.name_text_view)
    val valueTextView: TextView = view.findViewById(R.id.value_text_view)

    fun bind(metadata: Metadata?) {
        nameTextView.text = metadata?.name
        valueTextView.text = metadata?.value
    }
}