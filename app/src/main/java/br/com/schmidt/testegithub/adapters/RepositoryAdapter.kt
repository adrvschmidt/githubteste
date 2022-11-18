package br.com.schmidt.testegithub.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.schmidt.testegithub.adapters.viewholders.RepositoryViewHolder
import br.com.schmidt.testegithub.databinding.ItemRepositoryBinding
import br.com.schmidt.testegithub.models.ItemRepository

class RepositoryAdapter(private val list: List<ItemRepository?>, private val onClick: (ItemRepository) -> Unit): RecyclerView.Adapter<RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val itemRepositoryBinding = ItemRepositoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewHolder(itemRepositoryBinding, onClick)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        list[position]?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}