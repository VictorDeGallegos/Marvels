package mx.com.superheros.marvels.ui.home

import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import mx.com.superheros.marvels.R
import mx.com.superheros.marvels.data.model.Result
import mx.com.superheros.marvels.databinding.SeriesItemBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import mx.com.superheros.marvels.util.Constants.IMAGE_NOT_FOUND_URL

class SeriesItem(private val series: Result) : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.series_item

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val binding = SeriesItemBinding.bind(viewHolder.itemView)
        binding.apply {
            if (series.thumbnail.path != IMAGE_NOT_FOUND_URL) {
                // Usa Glide para cargar la imagen de la serie en tu ImageView
                Glide.with(root.context)
                    .load(series.thumbnail.path + "." + series.thumbnail.extension)
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(20))) // Añade esta línea
                    .into(seriesImage)

                val titleWithNewLine = series.title.replaceFirst("(", "\n(")
                seriesName.text = titleWithNewLine
                // seriesId.text = series.id.toString() con # antes
                seriesId.text = "#${series.id}"
            }
        }
    }
}