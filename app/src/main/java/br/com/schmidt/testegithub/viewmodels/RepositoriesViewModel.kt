package br.com.schmidt.testegithub.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import br.com.schmidt.testegithub.RepositoriesPagingSource
import br.com.schmidt.testegithub.MyApplication
import br.com.schmidt.testegithub.repositories.Repository
import kotlinx.coroutines.flow.catch
import javax.inject.Inject


class RepositoriesViewModel(application: Application) : AndroidViewModel(application) {

  //  @Inject
   // lateinit var repository: Repository

/*    private val repositoriesMutableLiveData = MutableLiveData<PagingData<ItemRepository?>>()

    val repositoriesLiveData: LiveData<PagingData<ItemRepository?>> get() = repositoriesMutableLiveData*/

    val flow = Pager(
        PagingConfig(pageSize = 15)
    ) {
        RepositoriesPagingSource(application)
    }.flow
        .cachedIn(viewModelScope).catch {
            Log.d("Adriano", "Entrou no erro do flow") }

/*    init {
        (application as MyApplication).getAppComponent().inject(this)
    }*/

/*    fun getRepositories() {
        Log.d("Adriano", "Entrou aqui 1")
        viewModelScope.async {
            Log.d("Adriano", "Entrou aqui 2")
            repository.getAllGithubJavaRepositories(3).let { list ->
                Log.d("Adriano", "Entrou aqui 3")
                  //  repositoriesMutableLiveData.postValue(list)
            }
        }
    }*/
}