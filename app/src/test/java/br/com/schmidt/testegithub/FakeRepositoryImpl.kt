package br.com.schmidt.testegithub

import br.com.schmidt.testegithub.models.ItemPullRequest
import br.com.schmidt.testegithub.models.ListRepositoriesObject
import br.com.schmidt.testegithub.repositories.Repository
import com.google.gson.Gson

class FakeRepositoryImpl : Repository {
    override suspend fun getAllGithubJavaRepositories(page: Int): ListRepositoriesObject? {
        val file = ClassLoader.getSystemResource("RepositoryItens.json").readText()
        return Gson().fromJson(file, ListRepositoriesObject::class.java)
    }

    override suspend fun getAllPullRequestsFromRepository(
        creator: String,
        repository: String,
        page: Int
    ): List<ItemPullRequest>? {
        TODO("Not yet implemented")
    }
}