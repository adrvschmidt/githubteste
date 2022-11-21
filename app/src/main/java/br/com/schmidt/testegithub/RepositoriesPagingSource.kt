package br.com.schmidt.testegithub

import android.app.Application
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.schmidt.testegithub.models.ItemRepository
import br.com.schmidt.testegithub.models.ListRepositoriesObject
import br.com.schmidt.testegithub.repositories.Repository
import kotlinx.coroutines.channels.BroadcastChannel
import java.util.concurrent.Flow
import javax.inject.Inject

class RepositoriesPagingSource constructor(application: Application): PagingSource<Int, ItemRepository>() {

    @Inject
    lateinit var backend: Repository

    init {
        (application as MyApplication).getAppComponent().inject(this)
    }

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, ItemRepository> {
        try {
            // Start refresh at page 1 if undefined.
            var countPage = 0
            params.key?.let {
                countPage = it
            }
            val nextPageNumber = countPage + 1
            Log.d("Adriano", "TEste 1: $nextPageNumber")
            val response = backend.getAllGithubJavaRepositories(nextPageNumber)
            response?.let {
                return LoadResult.Page(
                    data = it.items,
                    prevKey = null, // Only paging forward.
                    nextKey = nextPageNumber
                )
            }
        } catch (e: Exception) {
            return LoadResult.Error(e)
            // Handle errors in this block and return LoadResult.Error if it is an
            // expected error (such as a network failure).
        }
        return LoadResult.Error(Exception("Faio feio"))
    }

    override fun getRefreshKey(state: PagingState<Int, ItemRepository>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            Log.d("Adriano", "Testando aqui: ${state.closestPageToPosition(anchorPosition)}")
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}