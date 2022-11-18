package br.com.schmidt.testegithub.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import br.com.schmidt.testegithub.databinding.ItemRepositoryBinding
import br.com.schmidt.testegithub.models.ItemRepository
import com.bumptech.glide.Glide

class RepositoryViewHolder(private val binding: ItemRepositoryBinding, val onClick: (ItemRepository) -> Unit): RecyclerView.ViewHolder(binding.root) {

    private var currentSelected: ItemRepository? = null

    init {
        binding.root.setOnClickListener {
            currentSelected?.let { onClick(it) }
        }
    }

    fun bind(item: ItemRepository){
        currentSelected = item
        binding.apply {
            textViewRepositoryName.text = item.name
            textViewRepositoryFullName.text = item.full_name
            textViewRepositoryDescription.text = item.description
            textViewRepositoryStars.text = item.stargazers_count.toString()
            textViewRepositoryForks.text = item.forks_count.toString()
            textViewRepositoryUsername.text = item.name
            item.owner?.let {
                Glide
                    .with(imageViewUserPhoto)
                    .load(it.avatar)
                    .centerCrop()
                    .into(imageViewUserPhoto)
            }
        }
    }
}