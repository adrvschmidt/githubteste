package br.com.schmidt.testegithub.ui.pagings

import android.app.Application
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.schmidt.testegithub.MyApplication
import br.com.schmidt.testegithub.ui.models.ItemPullRequest
import br.com.schmidt.testegithub.ui.repositories.Repository
import br.com.schmidt.testegithub.utils.Constants
import javax.inject.Inject

class PullRequestPagingSource @Inject constructor(
    val backend: Repository
) : PagingSource<Int, ItemPullRequest>() {

    private var creator = ""
    private var repositoryName = ""

    fun registerRepositoryName(creatorFromFragment: String,
                               repositoryNameFromFragment: String){
        creator = creatorFromFragment
        repositoryName = repositoryNameFromFragment
    }

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, ItemPullRequest> {
        try {
            val nextPageNumber = Constants.returnPage(params.key)
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