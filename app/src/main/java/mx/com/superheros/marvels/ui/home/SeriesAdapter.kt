package mx.com.superheros.marvels.ui.home

import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import mx.com.superheros.marvels.data.model.Result

class SeriesAdapter : GroupAdapter<GroupieViewHolder>() {

    fun submitList(series: List<Result>) {
        clear()
        series.forEach { add(SeriesItem(it)) }
    }
}