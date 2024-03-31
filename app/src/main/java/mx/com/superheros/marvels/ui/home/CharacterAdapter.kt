package mx.com.superheros.marvels.ui.home

import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import mx.com.superheros.marvels.data.model.Result

class CharacterAdapter : GroupAdapter<GroupieViewHolder>() {

    fun submitList(characters: List<Result>) {
        clear()
        characters.forEach { add(CharacterItem(it)) }
    }
}