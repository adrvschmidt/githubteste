package br.com.schmidt.testegithub.retrofitInterface

import br.com.schmidt.testegithub.ui.models.ItemPullRequest
import br.com.schmidt.testegithub.ui.models.ListRepositoriesObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("/search/repositories?q=java+in%3Atopics&per_page=15")
    suspend fun getAllGithubJavaRepositories(@Query(value = "page") page: Int): Response<ListRepositoriesObject>

    @GET("/repos/{creator}/{repository}/pulls?q=&per_page=15")
    suspend fun getAllPullRequestsFromRepository(
        @Path("creator") creator: String,
        @Path("repository") repository: String,
        @Query(value = "page") page: Int
    ): Response<List<ItemPullRequest>>
}