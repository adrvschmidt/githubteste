package br.com.schmidt.testegithub.repositories

import br.com.schmidt.testegithub.models.ItemRepository
import br.com.schmidt.testegithub.models.ListRepositoriesObject
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryImpl: Repository {

    override suspend fun getAllGithubJavaRepositories(): Response<List<ItemRepository>> {

        return "" as Response<List<ItemRepository>>
    }

    override suspend fun getAllPullRequestsFromRepository() {
        TODO("Not yet implemented")
    }
}