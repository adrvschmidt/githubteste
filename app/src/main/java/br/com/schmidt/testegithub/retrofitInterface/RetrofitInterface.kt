package br.com.schmidt.testegithub.retrofitInterface

import br.com.schmidt.testegithub.models.ItemPullRequest
import br.com.schmidt.testegithub.models.ListRepositoriesObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("/search/repositories?q=java+in%3Atopics&per_page=6")
    suspend fun getAllGithubJavaRepositories(@Query(value = "page") page: String): Response<ListRepositoriesObject>

    @GET("/repos/{creator}/{repository}/pulls?q=&per_page=6&page=1")
    suspend fun getAllPullRequestsFromRepository(
        @Path("creator") creator: String,
        @Path("repository") repository: String,
        @Query(value = "page") page: String
    ): Response<List<ItemPullRequest>>
}