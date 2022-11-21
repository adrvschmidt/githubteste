package br.com.schmidt.testegithub.ui.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import br.com.schmidt.testegithub.ui.pagings.RepositoriesPagingSource
import br.com.schmidt.testegithub.ui.pagings.RepositoriesPagingSource_Factory
import kotlinx.coroutines.flow.catch
import javax.inject.Inject


class RepositoriesViewModel @Inject constructor(val repositoriesPagingSource: RepositoriesPagingSource) : ViewModel() {

    val flow = Pager(
        PagingConfig(pageSize = 15)
    ) {
        repositoriesPagingSource
    }.flow
        .cachedIn(viewModelScope).catch {
            Log.d("Adriano", "Entrou no erro do flow")
        }
}