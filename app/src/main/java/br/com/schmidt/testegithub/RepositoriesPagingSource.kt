package br.com.schmidt.testegithub

import android.app.Application
import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.schmidt.testegithub.models.ItemRepository
import br.com.schmidt.testegithub.repositories.Repository
import javax.inject.Inject

class RepositoriesPagingSource @Inject constructor(application: Application) :
    PagingSource<Int, ItemRepository>() {

    @Inject
    lateinit var backend: Repository

    init {
        (application as MyApplication).getAppComponent().inject(this)
    }

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, ItemRepository> {
        try {
            var countPage = 0
            params.key?.let {
                countPage = it
            }
            val nextPageNumber = countPage + 1
            val response = backend.getAllGithubJavaRepositories(nextPageNumber)
            response?.let {
                return LoadResult.Page(
                    data = it.items,
                    prevKey = null,
                    nextKey = nextPageNumber
                )
            }
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
        return LoadResult.Error(Exception("Faio feio"))
    }

    override fun getRefreshKey(state: PagingState<Int, ItemRepository>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}