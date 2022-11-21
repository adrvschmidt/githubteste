package br.com.schmidt.testegithub.ui.comparators

import androidx.recyclerview.widget.DiffUtil
import br.com.schmidt.testegithub.ui.models.ItemRepository

object RepositoriesItemComparator : DiffUtil.ItemCallback<ItemRepository>() {
    override fun areItemsTheSame(oldItem: ItemRepository, newItem: ItemRepository): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ItemRepository, newItem: ItemRepository): Boolean {
        return oldItem == newItem
    }
}