package br.com.schmidt.testegithub.adapters.viewholders

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import br.com.schmidt.testegithub.databinding.ItemPullRequestBinding
import br.com.schmidt.testegithub.databinding.ItemRepositoryBinding
import br.com.schmidt.testegithub.models.ItemPullRequest
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class PullRequestsViewHolder(
    private val binding: ItemPullRequestBinding,
    val onClick: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var currentSelected: String? = null

    init {
        binding.root.setOnClickListener {
            currentSelected?.let { onClick(it) }
        }
    }

    fun bind(item: ItemPullRequest) {
        currentSelected = item.webUrl
        binding.apply {
            textViewPullRequestTitle.text = item.title
            item.user?.let {
                Log.d("Adriano", "Teste 1: ${it.avatar}")
                textViewPullRequestUsername.text = it.userName
                Glide
                    .with(imageViewPullRequestUserPhoto)
                    .load(it.avatar)
                    .apply(RequestOptions.circleCropTransform())
                    .into(imageViewPullRequestUserPhoto)
            }
        }
    }
}