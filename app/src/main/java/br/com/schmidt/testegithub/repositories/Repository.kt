package br.com.schmidt.testegithub.repositories

import br.com.schmidt.testegithub.models.ItemPullRequest
import br.com.schmidt.testegithub.models.ItemRepository
import br.com.schmidt.testegithub.models.ListRepositoriesObject

interface Repository {

    suspend fun getAllGithubJavaRepositories(page: Int): ListRepositoriesObject?

    suspend fun getAllPullRequestsFromRepository(creator: String, repository: String, page: Int): List<ItemPullRequest>?
}