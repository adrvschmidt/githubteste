package br.com.schmidt.testegithub.ui.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import br.com.schmidt.testegithub.ui.pagings.PullRequestPagingSource
import br.com.schmidt.testegithub.ui.pagings.RepositoriesPagingSource
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

class PullRequestViewModel @Inject constructor(val pullRequestPagingSource: PullRequestPagingSource) : ViewModel() {

    val flow = Pager(
        PagingConfig(pageSize = 15),
    ) {
        pullRequestPagingSource
    }.flow
        .cachedIn(viewModelScope).catch {
            Log.d("Adriano", "Entrou no erro do flow")
        }

    fun setCreatorAndRepositoryName(
        creatorFromFragment: String,
        repositoryNameFromFragment: String
    ) {
        pullRequestPagingSource.registerRepositoryName(creatorFromFragment, repositoryNameFromFragment)
    }
}