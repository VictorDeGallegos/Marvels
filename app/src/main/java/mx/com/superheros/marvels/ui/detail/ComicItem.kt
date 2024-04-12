package mx.com.superheros.marvels.ui.detail

import android.content.Intent
import android.graphics.text.LineBreaker
import android.net.Uri
import android.text.Layout
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import mx.com.superheros.marvels.R

class ComicItem(private val comic: mx.com.superheros.marvels.data.model.DataX) : Item<GroupieViewHolder>() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            // Aquí puedes asignar los datos a las vistas de tu layout
            // por ejemplo: nombre del comic, imagen, etc.
            viewHolder.itemView.findViewById<TextView>(R.id.comicTitle).text = comic.results[position].title

            val comicDescription = viewHolder.itemView.findViewById<TextView>(R.id.comicDescription)
            //poner descripcion a 16 palabras
            val description = comic.results[position].description
            if (!description.isNullOrBlank()) {
                val words = description.split(" ")
                var shortDescription = ""
                for (i in 0 until 20) {
                    if (i < words.size) {
                        shortDescription += words[i] + " "
                    }
                }
                comicDescription.text = shortDescription + "..."
            } else {
                comicDescription.text = "Description not available"
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                comicDescription.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
            }

            // Obtén una referencia a tu ImageView
            val comicImage = viewHolder.itemView.findViewById<ImageView>(R.id.comicImage)

            // Usa Glide para cargar la imagen
            Glide.with(viewHolder.itemView)
                .load(comic.results[position].thumbnail.path + "." + comic.results[position].thumbnail.extension)
                .transform(RoundedCornersTransformation(20, 0, RoundedCornersTransformation.CornerType.ALL))
                .into(comicImage)

            //ISBN
            val comicISBN = viewHolder.itemView.findViewById<TextView>(R.id.comicISBN)
            if (!comic.results[position].isbn.isNullOrBlank()) {
                comicISBN.text = "ISBN: " + comic.results[position].isbn
            } else {
                comicISBN.text = "ISBN not available"
            }

            // price with symbol
            val comicPrice = viewHolder.itemView.findViewById<TextView>(R.id.comicPrice)
            if (comic.results[position].prices?.isNotEmpty() == true && comic.results[position].prices?.get(0)?.price != 0.0) {
                comicPrice.text = "$" + comic.results[position].prices?.get(0)?.price.toString()
            } else {
                comicPrice.text = "Price not available"
            }

            // Button to see more details
            val comicButton = viewHolder.itemView.findViewById<Button>(R.id.seeMoreButton)
            comicButton.setOnClickListener {
                // Navegar a url del comic
                val url = comic.results[position].urls[0].url
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                viewHolder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getLayout() = R.layout.item_comic
}