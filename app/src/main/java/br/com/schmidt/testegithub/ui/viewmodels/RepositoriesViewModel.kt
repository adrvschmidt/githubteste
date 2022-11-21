package br.com.schmidt.testegithub.ui.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import br.com.schmidt.testegithub.ui.pagings.RepositoriesPagingSource
import kotlinx.coroutines.flow.catch


class RepositoriesViewModel(application: Application) : AndroidViewModel(application) {

    val flow = Pager(
        PagingConfig(pageSize = 15)
    ) {
        RepositoriesPagingSource(application)
    }.flow
        .cachedIn(viewModelScope).catch {
            Log.d("Adriano", "Entrou no erro do flow")
        }
}