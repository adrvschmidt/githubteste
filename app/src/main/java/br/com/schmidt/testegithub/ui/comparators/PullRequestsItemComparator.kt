package br.com.schmidt.testegithub.ui.comparators

import androidx.recyclerview.widget.DiffUtil
import br.com.schmidt.testegithub.ui.models.ItemPullRequest
import br.com.schmidt.testegithub.ui.models.ItemRepository

object PullRequestsItemComparator: DiffUtil.ItemCallback<ItemPullRequest>() {
    override fun areItemsTheSame(oldItem: ItemPullRequest, newItem: ItemPullRequest): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ItemPullRequest, newItem: ItemPullRequest): Boolean {
        return oldItem == newItem
    }
}