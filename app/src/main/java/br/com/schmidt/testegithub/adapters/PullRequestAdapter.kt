package br.com.schmidt.testegithub.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.schmidt.testegithub.adapters.viewholders.PullRequestsViewHolder
import br.com.schmidt.testegithub.databinding.ItemPullRequestBinding
import br.com.schmidt.testegithub.models.ItemPullRequest
import br.com.schmidt.testegithub.models.ItemRepository

class PullRequestAdapter(diffCallback: DiffUtil.ItemCallback<ItemPullRequest>,
    private val onClick: (String) -> Unit
) : PagingDataAdapter<ItemPullRequest, PullRequestsViewHolder>(diffCallback) {

    lateinit var itemPullRequestBinding: ItemPullRequestBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestsViewHolder {
        itemPullRequestBinding = ItemPullRequestBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PullRequestsViewHolder(itemPullRequestBinding, onClick)
    }

    override fun onBindViewHolder(holder: PullRequestsViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }
    }
}