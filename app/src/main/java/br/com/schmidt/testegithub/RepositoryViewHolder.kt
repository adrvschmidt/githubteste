package br.com.schmidt.testegithub

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.schmidt.testegithub.databinding.ItemRepositoryBinding

class RepositoryViewHolder(private val binding: ItemRepositoryBinding, val onClick: (String) -> Unit): RecyclerView.ViewHolder(binding.root) {

    private var currentSelected: String? = null

    init {
        // Define click listener for the ViewHolder's View.
        binding.root.setOnClickListener {
            currentSelected?.let { onClick(it) }
        }
    }

    fun bind(title: String){
        currentSelected = title
        binding.textViewRepositoryName.text = title
    }
}