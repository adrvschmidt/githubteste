package br.com.schmidt.testegithub.repositories

import br.com.schmidt.testegithub.models.ItemRepository
import br.com.schmidt.testegithub.models.ListRepositoriesObject
import retrofit2.Response
import retrofit2.http.GET

interface Repository {

    @GET("/repositories?q=language:Kotlin&sort=stars&page=1")
    suspend fun getAllGithubJavaRepositories(): Response<List<ItemRepository>>

    @GET("/api/unknown")
    suspend fun getAllPullRequestsFromRepository()
}