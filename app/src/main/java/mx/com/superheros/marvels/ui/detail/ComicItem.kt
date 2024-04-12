package mx.com.superheros.marvels.ui.detail

import android.widget.TextView
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import mx.com.superheros.marvels.R

class ComicItem(private val comic: mx.com.superheros.marvels.data.model.Item) : Item<GroupieViewHolder>() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            // Aquí puedes asignar los datos a las vistas de tu layout
            // por ejemplo: nombre del comic, imagen, etc.
            viewHolder.itemView.findViewById<TextView>(R.id.comicName).text = comic.name
        }
    }

    override fun getLayout() = R.layout.item_comic
}