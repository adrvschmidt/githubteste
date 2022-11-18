package br.com.schmidt.testegithub.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.schmidt.testegithub.adapters.viewholders.PullRequestsViewHolder
import br.com.schmidt.testegithub.databinding.ItemPullRequestBinding
import br.com.schmidt.testegithub.models.ItemPullRequest

class PullRequestAdapter(
    private val list: List<ItemPullRequest?>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<PullRequestsViewHolder>() {

    lateinit var itemPullRequestBinding: ItemPullRequestBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestsViewHolder {
        itemPullRequestBinding = ItemPullRequestBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PullRequestsViewHolder(itemPullRequestBinding, onClick)
    }

    override fun onBindViewHolder(holder: PullRequestsViewHolder, position: Int) {
        list[position]?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}