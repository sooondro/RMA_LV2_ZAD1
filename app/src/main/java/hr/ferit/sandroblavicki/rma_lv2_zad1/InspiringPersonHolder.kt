package hr.ferit.sandroblavicki.rma_lv2_zad1

import android.view.View
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

import hr.ferit.sandroblavicki.rma_lv2_zad1.databinding.ItemPersonBinding

class InspiringPersonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(person: InspiringPerson, personListener: InspiringPersonInteractionListener) {
        var binding = ItemPersonBinding.bind(itemView)

        binding.tvPersonName.text = person.name
        binding.tvPersonDateOfBirth.text = person.dateOfBirth
        binding.tvPersonDescription.text = person.description
        Glide.with(binding.ivPersonImage).load(person.imageUrl).into(binding.ivPersonImage)
        binding.ivPersonImage.setOnClickListener { personListener.onShowDetails(person.id) }
    }
}