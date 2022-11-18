package br.com.schmidt.testegithub.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.schmidt.testegithub.MyApplication
import br.com.schmidt.testegithub.models.ItemPullRequest
import br.com.schmidt.testegithub.repositories.Repository
import kotlinx.coroutines.async
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

    fun getPullRequests(creator: String, repositoryName: String, page: String) {
        viewModelScope.async {
            repository.getAllPullRequestsFromRepository(creator, repositoryName, page).let { list ->
                pullRequestsMutableLiveData.postValue(list)
            }
        }
    }
}