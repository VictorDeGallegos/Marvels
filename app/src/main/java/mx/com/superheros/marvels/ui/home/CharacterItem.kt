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

class CharacterItem(private val character: Result) : BindableItem<CharacterItemBinding>() {

    override fun bind(viewBinding: CharacterItemBinding, position: Int) {
        viewBinding.characterName.text = character.name

        // Verifica si thumbnail.path es igual a la URL de la imagen no disponible
        if (character.thumbnail.path == IMAGE_NOT_FOUND_URL) {
            // Carga una imagen de "no disponible" en tu ImageView
            Glide.with(viewBinding.root.context)
                .load(R.drawable.image_not_found_icon)// Usa un recurso de Android predeterminado
                .apply(RequestOptions.bitmapTransform(RoundedCorners(20))) // Añade esta línea
                .into(viewBinding.characterImage)
        } else {
            // Usa Glide para cargar la imagen del personaje en tu ImageView
            Glide.with(viewBinding.root.context)
                .load(character.thumbnail.path + "." + character.thumbnail.extension)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(20))) // Añade esta línea
                .into(viewBinding.characterImage)
        }
    }

    override fun getLayout(): Int {
        return R.layout.character_item // Asegúrate de tener este layout en tu proyecto
    }

    override fun initializeViewBinding(view: View): CharacterItemBinding {
        return CharacterItemBinding.bind(view)
    }
}