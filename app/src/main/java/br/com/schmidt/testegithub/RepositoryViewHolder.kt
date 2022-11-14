package br.com.schmidt.testegithub

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.schmidt.testegithub.databinding.ItemRepositoryBinding
import br.com.schmidt.testegithub.models.ItemRepository

class RepositoryViewHolder(private val binding: ItemRepositoryBinding, val onClick: (ItemRepository) -> Unit): RecyclerView.ViewHolder(binding.root) {

    private var currentSelected: ItemRepository? = null

    init {
        // Define click listener for the ViewHolder's View.
        binding.root.setOnClickListener {
            currentSelected?.let { onClick(it) }
        }
    }

    fun bind(title: ItemRepository){
        currentSelected = title
        binding.apply {
            binding.textViewRepositoryName.text = title.name
            binding.textViewRepositoryFullName.text = title.full_name
            binding.textViewRepositoryDescription.text = title.description
            binding.textViewRepositoryStars.text = title.stargazers_count.toString()
            binding.textViewRepositoryForks.text = title.forks_count.toString()
            binding.textViewRepositoryUsername.text = title.name
        }
    }
}