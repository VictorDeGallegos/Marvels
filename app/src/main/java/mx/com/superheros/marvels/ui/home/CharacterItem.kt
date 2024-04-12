package mx.com.superheros.marvels.ui.home

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import mx.com.superheros.marvels.R
import mx.com.superheros.marvels.data.model.Result
import mx.com.superheros.marvels.databinding.CharacterItemBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import mx.com.superheros.marvels.util.Constants.IMAGE_NOT_FOUND_URL

class CharacterItem(private val character: Result, private val onClick: (String) -> Unit) : BindableItem<CharacterItemBinding>() {

    override fun bind(viewBinding: CharacterItemBinding, position: Int) {
        if (character.thumbnail.path != IMAGE_NOT_FOUND_URL) {
            viewBinding.root.visibility = View.VISIBLE

            // Reemplaza el primer paréntesis por un salto de línea
            val nameWithNewLine = character.name.replaceFirst("(", "\n(")
            viewBinding.characterName.text = nameWithNewLine
            viewBinding.characterName.textAlignment = View.TEXT_ALIGNMENT_CENTER

            // Usa Glide para cargar la imagen del personaje en tu ImageView
            Glide.with(viewBinding.root.context)
                .load(character.thumbnail.path + "." + character.thumbnail.extension)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(20))) // Añade esta línea
                .into(viewBinding.characterImage)

            // Agrega un OnClickListener al elemento
            viewBinding.root.setOnClickListener { onClick(character.id) }
        } else {
            viewBinding.root.visibility = View.GONE
        }
    }

    private fun onClick(id: Int) {
        onClick.invoke(id.toString())
    }

    override fun getLayout(): Int {
        return R.layout.character_item // Asegúrate de tener este layout en tu proyecto
    }

    override fun initializeViewBinding(view: View): CharacterItemBinding {
        return CharacterItemBinding.bind(view)
    }
}