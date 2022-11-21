package br.com.schmidt.testegithub.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import br.com.schmidt.testegithub.MyApplication
import br.com.schmidt.testegithub.RepositoriesPagingSource
import br.com.schmidt.testegithub.models.ItemPullRequest
import br.com.schmidt.testegithub.repositories.Repository
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class PullRequestViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var repository: Repository

    private val pullRequestsMutableLiveData = MutableLiveData<List<ItemPullRequest?>>()

    val pullRequestsLiveData: LiveData<List<ItemPullRequest?>> get() = pullRequestsMutableLiveData

    init {
        (application as MyApplication).getAppComponent().inject(this)
    }

    val flow = Pager(
        PagingConfig(pageSize = 15)
    ) {
        RepositoriesPagingSource(application)
    }.flow
        .cachedIn(viewModelScope).catch {
            Log.d("Adriano", "Entrou no erro do flow") }

    fun getPullRequests(creator: String, repositoryName: String, page: Int) {
        viewModelScope.async {
            repository.getAllPullRequestsFromRepository(creator, repositoryName, page).let { list ->
                pullRequestsMutableLiveData.postValue(list)
            }
        }
    }
}