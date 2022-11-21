package br.com.schmidt.testegithub

import android.app.Application
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.schmidt.testegithub.models.ItemPullRequest
import br.com.schmidt.testegithub.repositories.Repository
import javax.inject.Inject

class PullRequestPagingSource constructor(
    private val creator: String,
    private val repositoryName: String,
    application: Application
) : PagingSource<Int, ItemPullRequest>() {

    @Inject
    lateinit var backend: Repository

    init {
        (application as MyApplication).getAppComponent().inject(this)
    }

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, ItemPullRequest> {
        try {
            var countPage = 0
            params.key?.let {
                countPage = it
            }
            val nextPageNumber = countPage + 1
            Log.d("Adriano", "TEste 1: $nextPageNumber")
            val response =
                backend.getAllPullRequestsFromRepository(creator, repositoryName, nextPageNumber)
            response?.let {
                return LoadResult.Page(
                    data = it,
                    prevKey = null, // Only paging forward.
                    nextKey = nextPageNumber
                )
            }
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
        return LoadResult.Error(Exception("Faio feio"))
    }

    override fun getRefreshKey(state: PagingState<Int, ItemPullRequest>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}