package br.com.schmidt.testegithub.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import br.com.schmidt.testegithub.PullRequestPagingSource
import kotlinx.coroutines.flow.catch

class PullRequestViewModel(application: Application) : AndroidViewModel(application) {

    var creator: String = ""
    var repositoryName: String = ""

    val flow = Pager(
        PagingConfig(pageSize = 15)
    ) {
        PullRequestPagingSource(creator, repositoryName, application)
    }.flow
        .cachedIn(viewModelScope).catch {
            Log.d("Adriano", "Entrou no erro do flow")
        }

    fun setCreatorAndRepositoryName(
        creatorFromFragment: String,
        repositoryNameFromFragment: String
    ) {
        creator = creatorFromFragment
        repositoryName = repositoryNameFromFragment
    }
}