package br.com.schmidt.testegithub

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.schmidt.testegithub.databinding.ItemRepositoryBinding

class RepositoryAdapter(private val list: ArrayList<String>, private val onClick: (String) -> Unit): RecyclerView.Adapter<RepositoryViewHolder>() {

    lateinit var itemRepositoryBinding: ItemRepositoryBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        itemRepositoryBinding = ItemRepositoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewHolder(itemRepositoryBinding, onClick)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}