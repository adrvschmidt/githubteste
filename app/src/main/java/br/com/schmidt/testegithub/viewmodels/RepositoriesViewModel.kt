package br.com.schmidt.testegithub.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.schmidt.testegithub.MyApplication
import br.com.schmidt.testegithub.models.ItemPullRequest
import br.com.schmidt.testegithub.models.ItemRepository
import br.com.schmidt.testegithub.repositories.Repository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject


class RepositoriesViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var repository: Repository

    private val repositoriesMutableLiveData = MutableLiveData<List<ItemRepository?>>()

    val repositoriesLiveData: LiveData<List<ItemRepository?>> get() = repositoriesMutableLiveData

    init {
        (application as MyApplication).getAppComponent().inject(this)
    }

    fun getRepositories() {
        Log.d("Adriano", "Entrou aqui 1")
        viewModelScope.async {
            Log.d("Adriano", "Entrou aqui 2")
            repository.getAllGithubJavaRepositories("3").let { list ->
                Log.d("Adriano", "Entrou aqui 3")
                    repositoriesMutableLiveData.postValue(list)
            }
        }
    }
}