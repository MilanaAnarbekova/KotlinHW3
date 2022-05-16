package kg.geektech.kotlinhw3.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.kotlinhw3.common.extension.loadWithGlide
import kg.geektech.kotlinhw3.data.model.Pictures
import kg.geektech.kotlinhw3.databinding.ItemSelectedBinding

class AdapterGallery : RecyclerView.Adapter<AdapterGallery.PhotoViewHolder>() {

    private var list = arrayListOf<Pictures>()
    val selectedList = arrayListOf<Pictures>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            ItemSelectedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setList(list: ArrayList<Pictures>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class PhotoViewHolder(private val binding: ItemSelectedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(picture: Pictures) {
            binding.ivImage.loadWithGlide(picture.image)
            itemView.setOnClickListener {
                if (binding.selectionImage.isInvisible) {
                    binding.selectionImage.isVisible = true
                    selectedList.add(Pictures(picture.image))
                } else {
                    binding.selectionImage.isInvisible = true
                    selectedList.remove(Pictures(picture.image))
                }
            }
        }

    }
}