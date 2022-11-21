package br.com.schmidt.testegithub.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import br.com.schmidt.testegithub.adapters.viewholders.RepositoryViewHolder
import br.com.schmidt.testegithub.databinding.ItemRepositoryBinding
import br.com.schmidt.testegithub.models.ItemRepository

class RepositoryAdapter(
    diffCallback: DiffUtil.ItemCallback<ItemRepository>, private val onClick: (ItemRepository) -> Unit
) : PagingDataAdapter<ItemRepository, RepositoryViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val itemRepositoryBinding = ItemRepositoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RepositoryViewHolder(itemRepositoryBinding, onClick)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }
    }
}